package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.Type;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class DaoImpl implements DAO {
	
	/**
	 * Adds a user to the Bank_User table
	 * @param user
	 * @return the user that was added
	 */
	public User addUser(String firstName, String lastName, String username, String password, String email) {
		User user = new User();
		// Creates a connection to the database
		try (Connection connect = ConnectionUtil.getConnection();) {
			// SQL statement for getting all the users in the Bank User table
			String sql = "INSERT INTO Bank_User (first_name, last_name, user_name, password, email)"
					+ "VALUES (?, ?, ?, ?, ?)";
			String generatedColumns[] = { "user_id" };
			
			// Creates a PreparedStatement object for sending SQL statements to the database
			PreparedStatement ps = connect.prepareStatement(sql, generatedColumns);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, email);
			
			// Sets the fields of the User
			int row = ps.executeUpdate();
			if (row == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					user.setId(id);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setUsername(username);
					user.setPassword(password);
					user.setEmail(email);
				}
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get all the users from the Bank_User table
	 * @return a list of bank users
	 */
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		// Creates a connection to the database
		try (Connection connect = ConnectionUtil.getConnection();) {
			// SQL statement for getting all the users in the Bank User table
			String sql = "SELECT * FROM Bank_User";
			
			// Creates a Statement object for sending SQL statements to the database
			Statement stmt = connect.createStatement();
			
			// Executes the query and gets all the selected records and adds them to
			// the users ArrayList
			ResultSet info = stmt.executeQuery(sql);
			while (info.next()) {
				User u = new User();
				u.setId(info.getInt(1));
				u.setFirstName(info.getString(2));
				u.setLastName(info.getString(3));
				u.setUsername(info.getString(4));
				u.setPassword(info.getString(5));
				u.setEmail(info.getString(6));
				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Gets the record of a user with the specified username and password
	 * @param username
	 * @param password
	 * @return a user
	 */
	public User getUser(String username, String password) {
		User u = null;
		// Creates a connection to the database
		try (Connection connect = ConnectionUtil.getConnection();) {
			// SQL statement for getting specific user
			String sql = "SELECT * FROM Bank_User WHERE user_name = ? AND password = ?";
			
			// Creates a PreparedStatement object for sending SQL statements to the database
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2,  password);
			
			// Results from the sql query
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				u = new User();
				u.setId(info.getInt(1));
				u.setFirstName(info.getString(2));
				u.setLastName(info.getString(3));
				u.setUsername(info.getString(4));
				u.setPassword(info.getString(5));
				u.setEmail(info.getString(6));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get all the accounts associated with the given user
	 * @param userId
	 * @return list of accounts
	 */
	public ArrayList<Account> getAllAccounts(int userId) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		// Creates a connection to the database
		try (Connection connect = ConnectionUtil.getConnection();) {
			// SQL statement for getting all accounts of a specific user
			String sql = "SELECT * FROM Account ac INNER JOIN User_Account u ON ac.account_id = u.account_id AND u.user_id = ?";
			
			// Creates a PreparedStatement object for sending SQL statements to the database
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, userId);
			
			// Results from the sql query
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				Account a = new Account();
				a.setId(info.getInt(1));
				a.setBalance(info.getDouble(2));
				int num = info.getInt(3);
				Type type;
				if (num == 1) {type = Type.CHECKING;}
				else if (num == 2) {type = Type.SAVINGS;}
				else {type = Type.CREDIT;}
				a.setType(type);
				a.setOpenDate(info.getDate(4).toLocalDate());
				if (info.getDate(5) != null)
					a.setCloseDate(info.getDate(5).toLocalDate());
				else 
					a.setCloseDate(null);
				accounts.add(a);
			}
			return accounts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Adds an account 
	 * @param userId
	 * @param type
	 * @return the account id
	 */
	public int addAccount(int userId, int type) {
		int accountId = -1;
		// Creates a connection to the database
		try (Connection connect = ConnectionUtil.getConnection();) {
			connect.setAutoCommit(false);
			
			// Creates a savepoint
			Savepoint s = connect.setSavepoint();
			
			// SQL query to insert an account int the Account table
			String sql = "INSERT INTO Account (type_id) VALUES (?)";
			
			// The account_id of the Account table is automatically generated so the following lines
			// allows us to obtain the generated id
			String generatedColumns[] = { "account_id" };
			
			// Creates a PreparedStatement object for sending SQL statements to the database
			PreparedStatement ps = connect.prepareStatement(sql, generatedColumns);
			ps.setInt(1, type);
			
			// Executes the insert query
			int row = ps.executeUpdate();
			if (row == 1) {
				// Gets the key that was generated
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					
					// SQL query to insert a record into the User_Account junction table
					String sql2 = "INSERT INTO User_Account VALUES (?, ?)";
					
					// Creates a PreparedStatement object for sending SQL statements to the database
					PreparedStatement ps2 = connect.prepareStatement(sql2);
					ps2.setInt(1, userId);
					ps2.setInt(2, id);
					
					// Executes the insert query
					int row2 = ps2.executeUpdate();
					if (row2 == 1) {
						accountId = id;
					}
					else
						connect.rollback(s);
				}
			}
			else {
				System.out.println("Error");
				connect.rollback(s);
			}
			connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountId;
	}
	
	/**
	 * Get the specific account information
	 * @param id
	 * @return an account
	 */
	public Account getAccountById(int id) {
		Account account = null;
		try (Connection connect = ConnectionUtil.getConnection();) {
			String sql = "SELECT * FROM Account WHERE account_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account = new Account();
				account.setId(rs.getInt(1));
				account.setBalance(rs.getDouble(2));
				int num = rs.getInt(3);
				Type type;
				if (num == 1) {type = Type.CHECKING;}
				else if (num == 2) {type = Type.SAVINGS;}
				else {type = Type.CREDIT;}
				account.setType(type);
				account.setOpenDate(rs.getDate(4).toLocalDate());
				if (rs.getDate(5) != null)
					account.setCloseDate(rs.getDate(5).toLocalDate());
				else 
					account.setCloseDate(null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
	/**
	 * Update the balance of an account
	 * @param a
	 * @return true if balance updated, false otherwise
	 */
	public boolean updateBalance(int id, double amount) {
		try (Connection connect = ConnectionUtil.getConnection();) {
			// SQL query for updating the balance of a specific account
			String sql = "UPDATE Account SET balance = ? WHERE account_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, id);
			
			int row = ps.executeUpdate();
			if (row == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Close an account by setting the close_date attribute to current date
	 * @param id
	 * @return true if account closed, false otherwise
	 */
	public boolean closeAccount(int id) {
		try (Connection connect = ConnectionUtil.getConnection();) {
			 String sql = "{call close_account(?)";
			
			CallableStatement cs = connect.prepareCall(sql);
			cs.setInt(1, id);
			
			int row = cs.executeUpdate();
			if (row == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
