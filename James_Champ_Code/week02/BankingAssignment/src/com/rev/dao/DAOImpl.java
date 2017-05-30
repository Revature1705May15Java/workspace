package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rev.log.Logger;
import com.rev.pojos.Account;
import com.rev.pojos.AccountType;
import com.rev.pojos.User;
import com.rev.util.ConnectionUtil;

// TODO: Add comments.
public class DAOImpl implements DAO{
	private static Logger log = new Logger();
	
	@Override
	public int updateBalance(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUser(String firstName, String lastName, String password, String email) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "{CALL create_new_user(?, ?, ?, ?)}";
		
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, firstName);
			cs.setString(2, lastName);
			cs.setString(3, password);
			cs.setString(4, email);
			
			int num = cs.executeUpdate();
			
			log.log(num + " users added.");
			
			return num;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public User getUser(String email) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql =	"SELECT * FROM users " +
							"WHERE email = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			User user = null;
			
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
			}
			
			// TODO: Log results
			
			return user;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Account> getUserAccounts(User user) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT account_id FROM user_accounts " +
						 "WHERE user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accountNumber = rs.getInt(1);
				Account a = getAccount(accountNumber);
				
				if(a != null) {
					accounts.add(a);
				}
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	// TODO: Make a stored procedure for this query.
	@Override
	public ArrayList<User> getAccountHolders(Account account) {
		ArrayList<User> accountHolders = new ArrayList<User>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT user_id FROM user_accounts " +
						"WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account.getAccountId());
			
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> accountIds = new ArrayList<Integer>();
			
			while(rs.next()) {
				accountIds.add(rs.getInt(1));
			}
			
			sql = "SELECT user_id, first_name, last_name FROM users "
					+ "WHERE user_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			for(int i : accountIds) {
				ps.setInt(1, i);
				
				rs = ps.executeQuery();
				rs.next();
				User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
				accountHolders.add(u);
			}
					
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return accountHolders;
	}

	// TODO: Fix this method. Create a procedure in oracle that returns a single accounts row.
	@Override
	public Account addAccount(Account account, User user) {	
		Account newAccount = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{create_new_account(?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, account.getType().getTypeId());
			cs.setInt(2, user.getId());
			
			int numCreated = cs.executeUpdate();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				System.out.println(numCreated);
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getDouble(3));
				System.out.println(rs.getDate(4).toString());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return newAccount;
	}

	@Override
	public Account getAccount(int accountId) {
		Account account = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts " +
						 "WHERE account_id = ? AND close_date IS NULL";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				account = new Account();
				account.setAccountId(rs.getInt(1));
				account.setType(new AccountType(rs.getInt(2)));
				account.setBalance(rs.getDouble(3));
				account.setOpenDate(rs.getDate(4));
				account.setCloseDate(rs.getDate(5));
			}
			
			return account;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}
	
	@Override
	public int closeAccount(Account account) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL close_account(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, account.getAccountId());
			
			int numClosed = cs.executeUpdate();
			
			return numClosed;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
