package com.rev.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.Account;
import com.rev.pojos.AccountType;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

// TODO: Add comments.
public class DAOImpl implements DAO{
	
	@Override
	public int updateBalance(Account account) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE accounts " +
						"SET balance = ? " +
						"WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setInt(2, account.getAccountId());
			
			int numUpdated = ps.executeUpdate();
			
			if(numUpdated != 1) {
				// TODO: Throw exception
			}
			
			return numUpdated;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int addUser(String firstName, String lastName, String password, String email) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{CALL create_new_user(?, ?, ?, ?)}";
		
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, firstName);
			cs.setString(2, lastName);
			cs.setString(3, password);
			cs.setString(4, email);
			
			int num = cs.executeUpdate();
						
			return num;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public User getUser(String email) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
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
	public User getUser(int id) {
		User result = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT first_name, last_name " +
						"FROM users WHERE user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new User();
				result.setId(id);
				result.setFirstName(rs.getString(1));
				result.setLastName(rs.getString(2));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@Override
	public ArrayList<Account> getUserAccounts(User user) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
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
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
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

	@Override
	public Account addAccount(Account account, User user) {	
		Account newAccount = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO accounts(type_id) " +
						 "VALUES(?)";
		
			String[] key = {"account_id"};
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, account.getType().getTypeId());
			
			int result = ps.executeUpdate();
			
			if(result != 1) {
				// TODO: Indicate that something went wrong.
			}
			
			ResultSet rs = ps.getGeneratedKeys();

			rs.next();
			
			int accountId = rs.getInt(1);
			
			sql = "INSERT INTO user_accounts(user_id, account_id) " +
					"VALUES(?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setInt(2, accountId);
			
			result = ps.executeUpdate();
			
			if(result != 1) {
				// TODO: Indicate that something went wrong.
			}
			
			sql = "SELECT * FROM accounts " +
					"WHERE account_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, accountId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				newAccount = new Account();
				newAccount.setAccountId(rs.getInt(1));
				newAccount.setType(new AccountType(rs.getInt(2)));
				newAccount.setBalance(rs.getDouble(3));
				newAccount.setOpenDate(rs.getDate(4));
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
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
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
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
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
	
	@Override
	public int addAccountHolder(Account account, User accountHolder) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO user_accounts " +
						"VALUES(?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountHolder.getId());
			ps.setInt(2, account.getAccountId());
			
			int numInserted = ps.executeUpdate();
			
			return numInserted;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public ArrayList<Integer> getAccountTypes() {
		ArrayList<Integer> types = new ArrayList<Integer>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT type_id FROM account_types";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				types.add(rs.getInt(1));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return types;
	}
}
