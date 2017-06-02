package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.bank.logs.Logger;
import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.util.ConnectionFactory;
import com.bank.util.ConnectionUtil;

public class DaoImpl implements DAO{
	
	static Logger Logger = new Logger();
	
	//use return value to return current balance
	@Override
	public double updateBalance(Account account, double newbal) {
		//DAO dao = new DaoImpl();
		double x = 0;
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "insert into account(balance)"
					+ "values(?) where acct_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			x = newbal + account.getBalance(); 
			ps.setDouble(1, x);
			ps.setInt(2, account.getId());
			
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int addUser(String fn, String ln, String uname, String pw) {
		try(Connection connect = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO USERS(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) "
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, uname);
			ps.setString(4, pw);
			
			int num = ps.executeUpdate();
			Logger.log(num + " Users Added");
			
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.log(e.getSQLState());
		}
		return 0;
	}

	@Override
	public User getUser(String uname, String pw) {
		User u = new User();
		//DAO dao = new DaoImpl();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String sql ="SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pw);
			
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				u.setId(userinfo.getInt(1));
				u.setFn(userinfo.getString(2));
				u.setLn(userinfo.getString(3));
				u.setPw(userinfo.getString(4));
				u.setUname(userinfo.getString(5));
//				u.setUserAccounts(dao.showAccounts(u.getId()));
			}
			
			if(u.getUname() != null){
//				System.out.println("User: " + u.toString());
			}else{
				System.out.println("Attempted to Find a Non-Existent User");
				return null;
			}
			
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.log(e.getSQLState());
		}
		return null;
	}

	@Override
	public User getUser(int id) {
		User u = new User();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from users where u_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			//id, fn, ln, em, pw
			while(info.next()){
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setUname(info.getString(4));
				u.setPw(info.getString(5));
			}
			return u;
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		return null;
	}
	//needs multiple account holders
	@Override
	public void addAccount(User u, double bal, int type) {
		DAO dao = new DaoImpl();
		Account a = null;
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "insert into ACCOUNT(balance, type_id) "
					+ "values(?, ?)";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setDouble(1, bal);
			ps.setInt(2, type);
			
			int accId = dao.getRecentAccount();
			dao.updateJoin(u, accId);
			
			a = dao.getAccount(accId);
//			a.setAccount_holders(dao.getAllUserOnAccount(a));
			int count = ps.executeUpdate();
			if(count!=0){
            	System.out.println("Added Account: " + a.toString());
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Account> showAccounts(int uid) {
		ArrayList<Account> arr = new ArrayList<Account>();
		Account a = new Account();
		try(Connection connect = ConnectionUtil.getConnection();){
//			String sql = "select user_account.account_id, account.balance"
//					+ "from account full outer join user_account on user_id = ?";
			String sql = "SELECT account.acct_id, account.balance, account.opened, account.closed, accounttype.t_id "
					+ "FROM user_account "
					+ "INNER JOIN users ON user_account.user_id = users.u_id "
					+ "INNER JOIN account ON user_account.account_id = account.acct_id "
					+ "INNER JOIN accounttype ON accounttype.t_id = account.type_id "
					+ "WHERE users.u_Id=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ps.setInt(1, uid);
			
			ResultSet info = ps.executeQuery();
			//aid, bal, typeid, open, close
			while(info.next()){
				a.setId(info.getInt(1));
				a.setBalance(info.getDouble(2));
				
				a.setDateOpened(info.getDate(3));
				a.setDateClosed(info.getDate(4));
				a.setType(info.getInt(5));
				System.out.println(a.toString());
				arr.add(a);
			}
			info.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No Accounts");
		} catch (NullPointerException e){
			System.out.println("You have 0 accounts");
		}
		return null;
		
	}
	
	@Override
	public Account getAccount(int aid) {
		Account a = new Account();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from account where acct_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, aid);
			
			ResultSet info = ps.executeQuery();
			while(info.next()){
				a.setId(info.getInt(1));
				a.setBalance(info.getDouble(2));
				a.setType(info.getInt(3));
				a.setDateOpened(info.getDate(4));
				a.setDateOpened(info.getDate(5));
			}
			System.out.println(a.toString());
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public boolean closeAccount(Account a) {
		try (Connection connect = ConnectionUtil.getConnection();) {
			 String sql = "{call close_acct(?)";
			
			CallableStatement cs = connect.prepareCall(sql);
			cs.setInt(1, a.getId());
			
			int rows = cs.executeUpdate();
			if (rows == 1){
				System.out.println("Account Closed");
				return true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int getRecentAccount() {
		int out = 0;
		try(Connection connect = ConnectionUtil.getConnection();){
			String recent = "{? = call GET_RECENT_ACCID}";
			CallableStatement cs = connect.prepareCall(recent);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			
			out = cs.getInt(1);
			return out;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//updates the join table
	@Override
	public void updateJoin(User u, int accountId) {
//		DAO dao = new DaoImpl();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "insert into user_account values( "+ u.getId() + ", " + accountId + ")";
			Statement statement = connect.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num rows affected: "+ numRowsAffected);
//			String sql2 = "insert into USER_ACCOUNT(user_id, account_id)"
//					+ "values(?, ?)";
//			PreparedStatement ps2 = connect.prepareStatement(sql2);
//			ps2.setInt(1, u.getId());
//			ps2.setInt(2, dao.getRecentAccount());
//			int num = ps2.executeUpdate();
//			System.out.println("Number of Rows Affected in User_Account: " + num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public double getBalance(Account account) {
		double x = 0;
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select balance"
					+ "from account where acct_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, account.getId());
			
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				x = userinfo.getDouble(1);
//				account.setBalance(x);
				
			}
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	//assuming we have the account check all the users
	@Override
	public ArrayList<User> getAllUserOnAccount(Account a) {
		ArrayList<User> usr = new ArrayList<User>();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "SELECT * FROM users INNER JOIN user_account "
					+ "ON user.user_id = user_account.user_id AND user_account.account_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, a.getId());
			
			ResultSet info = ps.executeQuery();
			while(info.next()){
				User u = new User();
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setUname(info.getString(4));
				u.setPw(info.getString(5));
				usr.add(u);
			}
			return usr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usr;
	}
	
	//ask user to insert userid for the user the want to add
	@Override
	public boolean addUserToAccount(Account a, int userId) throws SQLIntegrityConstraintViolationException {
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "INSERT INTO User_Account VALUES (?, ?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2,  a.getId());
			
			int row = ps.executeUpdate();
			if (row == 1){
				return true;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}

	@Override
	public boolean checkClosedAccount(Account a) {
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select closed from account where acct_id = ?;";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ResultSet info = ps.executeQuery();
			while(info.next()){
				if(info.getDate(1)==null){
					return false;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
