package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class Impldao implements Dao{
	
	static Logger log = new Logger();
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Account> accounts = new ArrayList<Account>();
	
	@Override
	public int updateBalance(Account account, double newbal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUser(String fn, String ln, String userName, String password) {
		int numRowsAffected = 0;
		
		try(Connection connection = ConnectionUtil.getConnection();){
			
			String sql = "INSERT INTO bank_users(first_name,last_name,password,user_name)"
						+ "VALUES (?,?,?,?)";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, password);
			ps.setString(4, userName);
			
			numRowsAffected = ps.executeUpdate();
			log.log("Num rows affected: " + numRowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numRowsAffected;
	}

	public User getUser(String userName) {
		User u = new User();
		
		try(Connection connection = ConnectionUtil.getConnection();){
			
			String sql = "SELECT * FROM bank_users WHERE user_name = ?";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userName);
			
			ResultSet info = ps.executeQuery();
			while(info.next()){ 
				u.setId(info.getInt(1));  
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPassword(info.getString(4));
				u.setUsername(info.getString(5));

				u.setAccounts(getUserAccounts(u.getId()));
			}
			
			if(u.getUsername() != null)log.log("Retrieved user by username: " + userName);
			else {
				log.log("Failed to retrieve user by username: " + userName);
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	public void makeDeposit(Account acc, int addBalance) {
		try(Connection connection = ConnectionUtil.getConnection();){
					
			String sql = "UPDATE accounts SET balance = balance + ? WHERE acc_id = ?";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, addBalance);
			ps.setInt(2, acc.getId());
			
			ps.executeUpdate();

			log.log("Updated acc #" + acc.getId() + " balance by " + addBalance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void makeWithdrawal(Account acc, int reduceBalance) {
		try(Connection connection = ConnectionUtil.getConnection();){
			reduceBalance *= -1;
			String sql = "UPDATE accounts SET balance = balance + ? WHERE acc_id = ?";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, reduceBalance);
			ps.setInt(2, acc.getId());
			
			ps.executeUpdate();

			log.log("Reduced acc #" + acc.getId() + " balance by " + reduceBalance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean editAcc(String edits, User u) {
		String[] stuff = edits.split(":");
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "UPDATE bank_users SET " + stuff[0] + " = ? WHERE userid = ?";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, stuff[1]);
			ps.setInt(2, u.getId());
			
			ps.executeUpdate();

			log.log("Edited User " + u.getUsername() + ". " + stuff[0] + " = " + stuff[1]); 
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public User getUser(int id) {
		User u = new User();
		
		try(Connection connection = ConnectionUtil.getConnection();){
			
			String sql = "SELECT * FROM bank_users WHERE userid = ?";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			while(info.next()){ 
				u.setId(info.getInt(1));  
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPassword(info.getString(4));
				u.setUsername(info.getString(5));

				u.setAccounts(getUserAccounts(u.getId()));
			}
			
			if(u.getUsername() != null)log.log("Retrieved user by userid: " + id);
			else {
				log.log("Failed to retrieve user by userid: " + id);
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	private void getAllUsers(){
		users = new ArrayList<User>();
		User temp = new User();
		
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "SELECT * FROM bank_users";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet info = ps.executeQuery();
			int i = 0;
			while(info.next()){
				
				temp = new User();
				temp.setId(info.getInt(1));  
				temp.setFn(info.getString(2));
				temp.setLn(info.getString(3));
				users.add(i, temp);
				i++;			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Account addAccount(int accType, int balance, int cust_id) {
		Account temp = new Account();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "INSERT INTO accounts (balance, type_id) VALUES(?, ?)";
			String sql2 = "INSERT INTO user_account (userid, acc_id) VALUES(?, (SELECT MAX(acc_id) FROM accounts))";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setInt(2, accType);
			
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, cust_id);
						
			int row = ps.executeUpdate();
			ps2.executeUpdate();
			log.log("New Accounts added: " + row);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}
	
	public int closeAccount(Account acc) {
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "UPDATE accounts SET closed = current_date WHERE acc_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, acc.getId());
						
			int row = ps.executeUpdate();
			log.log("Account " + acc.getId() + " closed: " + row);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 1;
	}
	
	private void getAccounts(){ 
		accounts = new ArrayList<Account>();
		Account temp = new Account();
		
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "SELECT * FROM accounts";
			String sql2 = "SELECT type_name FROM accounttype WHERE type_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			
			ResultSet info = ps.executeQuery();
			int i = 0, num = 0;
			while(info.next()){
				
				temp = new Account();
				temp.setId(info.getInt(1));  
				temp.setBalance(info.getDouble(2));
				
				num = info.getInt(3);
				ps2.setInt(1, num); // setting account type so it can be queried each iteration to
									// collect the correct account type in the look-up table.
				ResultSet info2 = ps2.executeQuery();
				info2.next();
				temp.setType(info2.getString(1));
				
				temp.setDateOpened(info.getDate(4));
				temp.setDateClosed(info.getDate(5));
				temp.toString();
				accounts.add(i, temp);
				i++;			
			}
			
		} catch (SQLException e) {
			log.log("Fetching account failed.");
		}
	}
	
	public ArrayList<Account> getUserAccounts(int id) {
		
		getAccounts();
		
		ArrayList<Account> accs = new ArrayList<Account>();
		Account temp = new Account();
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "SELECT * FROM user_account WHERE userid = " + id;
			
			Statement st = connection.createStatement();
			
			
			ResultSet info = st.executeQuery(sql);
			
			int i = 1, counter = 0;
			while(info.next()){
				int num = info.getInt(2);
				for(int k = 0; k < accounts.size(); k++) {
					if (accounts.get(k).getId() == num && accounts.get(k).getDateClosed() == null) {
						accs.add(accounts.get(k));
						counter++;
					}
				}
				i++;
			}
			log.log("User Accounts for id: '" + id + "' successfully collected." );
			return accs;
			
		} catch (SQLException e) {
			log.log("Collecting user Accounts for id: '" + id + "' FAILED." );
		}
		
		
		return null;
	}

	@Override
	public void joinAcc(Account acc, User u) {
		Account temp = new Account();
		try(Connection connection = ConnectionUtil.getConnection();) {
			String sql = "INSERT INTO user_account (userid, acc_id) VALUES(?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setInt(2, acc.getId());
						
			int row = ps.executeUpdate();
			log.log("New User_account added: " + row);		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int transferMoney(Account acc, int accNum, int balance){
		Account temp = null;

		for(int i = 0; i < accounts.size(); i++){
			if(accounts.get(i).getId() == accNum){
				temp = accounts.get(i);
				break;
			}
		}
		if(temp == null) return -1; // If account number entered not found, return failure (-1).
		
		/*
		 * Callable order of operations: First, withdraw money, then deposit in new acc.
		 */
		try(Connection connection = ConnectionUtil.getConnection();){
			String addOrder = "{call transfer_money(?,?,?)}";
			
			CallableStatement cs = connection.prepareCall(addOrder);
			
			cs.setInt(1, acc.getId());  // active account (withdrawal)
			cs.setInt(2, temp.getId()); // destination account (deposit)
			cs.setInt(3, balance);      // amount of money exchanged
			
			int num = cs.executeUpdate();
			log.log("Transfer Successful: " + acc.getId() + " and " + temp.getId() + " for " + balance);		
		} catch (SQLException e) {
			log.log("Transfer FAILED: " + acc.getId() + " and " + temp.getId() + " for " + balance);
			return -1;
		}
		
		return 1;
	}

}
