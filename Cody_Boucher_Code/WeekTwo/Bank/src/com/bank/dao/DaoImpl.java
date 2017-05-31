package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

public class DaoImpl implements DAO{
	static Logger logger = new Logger();
	//basic bank functions

	//update user account, used for all updates including deposit, withdraw, closing account
	@Override
	public Account upDateAccount(Account account) {
		Account temp = null;
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "upDate account set balance = ?, closed_Date = ? where account_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setDate(2, (account.getCloseDate() == null) ? null : Date.valueOf(account.getCloseDate()));
			ps.setInt(3, account.getId());
			ps.execute();
			temp = account;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	//add new user to the bank, does not automatically add an account
	@Override
	public User addUser(String firstName, String lastName, String userName, String password) {
		try (Connection connection = ConnectionUtil.getConnection()) {
	      String sql = "insert into USERS (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) values (?, ?, ?, ?)";
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setString(1, firstName);
	      ps.setString(2, lastName);
	      ps.setString(3, userName);
	      ps.setString(4, password);
	      

	     int num = ps.executeUpdate();
	     Logger.log(num + " users added.");
	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	}

	//returns user based on username
	@Override
	public User getUser(String userName) {
		User u = new User();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from USERS where USERNAME = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet info = ps.executeQuery();
			while( info.next()) {
				u.setId(info.getInt(1));
				u.setFirstName(info.getString(2));
				u.setLastName(info.getString(3));
				u.setPassword(info.getString(4));
				u.setUsername(info.getString(5));
			}
			u.setUserAccounts(getAccountIds(u));
			if(u.getUsername()!= null) {
				Logger.log("Retrieved user by username " + u.toString());
			}
			else {
				Logger.log("Attempted to retrieve non-existant user!");
			}
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Error");
		return null;
	}
	
	//uses statement to get user by ID
	@Override
	public User getUserById(int id) {
		User u = new User();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from USERS where USER_ID = '" + id + "'";
			Statement statement = connection.createStatement();
			ResultSet info = statement.executeQuery(sql);
			while(info.next()) {
				u.setFirstName(info.getString(2));
				u.setLastName(info.getString(3));
				u.setUsername(info.getString(4));
				u.setPassword(info.getString(5));
			}
			if(u.getUsername()!= null) {
				Logger.log("Retrieved user by id " + u.toString());
			}
			else {
				Logger.log("Attempted to retrieve non-existant user");
			}
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//gets an account using account id
	@Override
	public Account getAccount(int id) {
		Account a = new Account();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from ACCOUNT where ACCOUNT_ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while( info.next()) {
				a.setId(info.getInt(1));
				a.setBalance(info.getDouble(2));
				a.setType(info.getInt(3));
				a.setOpenDate(info.getDate(4).toLocalDate());
			}
			
			if(a.getId() != 0) {
				Logger.log("Retrieved account by id " + a.toString());
			}
			else {
				Logger.log("Attempted to retrieve non-existant account!");
			}
			return a;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Error");
		return null;
	}

	//NEED TO INNER JOIN ON ACCOUNT AND ACCOUNT TYP TO GET ALL ACCOUNTS
	@Override
	public ArrayList<Account> getAllAccounts(User user) {
		int numAccounts = 0;
		ArrayList<Account> accounts = new ArrayList<Account>();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select account.ACCOUNT_ID, account.TYPE_ID, account.BALANCE"
					+ ", account.OPEN_Date, account.CLOSED_Date from account "
					+ "inner join USERACCOUNT on account.ACCOUNT_ID"
					+ " = USERACCOUNT.ACCOUNT_ID and USERACCOUNT.USER_ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				Account a = new Account();
				a.setId(info.getInt(1));
				a.setType(info.getInt(2));
				a.setBalance(info.getInt(3));
				a.setOpenDate(info.getDate(4).toLocalDate());
				if(info.getDate(5) != null) {
					a.setCloseDate(info.getDate(5).toLocalDate());
				}
				else {
					a.setCloseDate(null);
				}
				a.setAccountHolders(getUserIds(a));
				accounts.add(a);
				System.out.println(a.toString());
				numAccounts++;
			}
			if(numAccounts != 0) {
				Logger.log(numAccounts + " accounts retrieved for userID " + user.getId());
			}
			else {
				Logger.log("No accounts were discovered for this user!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	//adds an account to a user
	@Override
	public Account addAcount(User user, int typeId) {
		Account account = new Account();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "insert into account (type_id) values(?) returning account_id into ?";
			OraclePreparedStatement ps = (OraclePreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, typeId);
			ps.registerReturnParameter(2, OracleTypes.NUMBER);
			int count = ps.executeUpdate();
			if(count > 0) {
				ResultSet info = ps.getReturnResultSet();
				if(info.next()) {
					int newAccountId = info.getInt(1);
					String sql2 = "insert into useraccount values(?, ?)";
					PreparedStatement ps2 = connection.prepareStatement(sql2);
					ps2.setInt(1, user.getId());
					ps2.setInt(2, newAccountId);
					ps2.executeUpdate();
					Logger.log("account added with account id of " + newAccountId);
				}
				else {
					Logger.log("error");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	

	//returns an arraylist of all user id's associated with an account
	private ArrayList<Integer> getUserIds(Account a) {
		ArrayList<Integer> userIds = new ArrayList<Integer>();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select user_id from useraccount where account_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,  a.getId());
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				userIds.add(info.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userIds;
	}
	
	//returns an arraylist of accounts associated with a user id
	private ArrayList<Integer> getAccountIds(User u) {
		ArrayList<Integer> accountIds = new ArrayList<Integer>();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select account_id from useraccount where user_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				accountIds.add(info.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountIds;
		
	}

	//returns all the account types from the lookup table
	@Override
	public ArrayList<AccountType> getAccountType() {
		ArrayList<AccountType> types = new ArrayList<AccountType>();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from accounttype";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				AccountType a = new AccountType();
				a.setId(info.getInt(1));
				a.setName(info.getString(2));
				System.out.println(a.toString());
				types.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//calls a stored procedure to transfer funds from one account to another
	@Override
	public void transfer(int sendingId, int recievingId, double amount) {
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "{call transfer(?, ?, ?)}";
			CallableStatement info = connection.prepareCall(sql);
			info.setInt(1, sendingId);
			info.setInt(2, recievingId);
			info.setDouble(3, amount);
			info.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	//adds a user to an account to create a joint account
	@Override
	public void addAccountUser(User u, Account a) {
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "insert into useraccount(user_id, account_id) values(?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setInt(2, a.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	