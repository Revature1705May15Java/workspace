package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.bank.logs.Logger;
import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.util.ConnectionUtil;

public class DaoImpl implements DAO{
	
	static Logger Logger = new Logger();
	@Override
	public int updateBalance(Account account, double newbal) {
		// TODO Auto-generated method stub
		return 0;
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
		try(Connection connect = ConnectionUtil.getConnection()){
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
			}
			
			if(u.getUname() != null){
				Logger.log("Users Found by Username: " + u.toString());
			}else{
				Logger.log("Attempted to Find a Non-Existent User");
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
			e.printStackTrace();
		}
		return null;
	}
	//needs multiple account holders
	@Override
	public Account addAccount(User u, double bal, int type) {
		Account a = new Account();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "insert into ACCOUNT(balance, type_id) "
					+ "values(?, ?)";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setDouble(1, bal);
			ps.setInt(2, type);
			
			ResultSet info = ps.executeQuery();
			//aid, bal, typeid, open, close
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
	public void showAccounts(int uid) {
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select user_account.account_id, account.balance"
					+ "from account full outer join user_account on user_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ps.setInt(1, uid);
			ps.executeQuery();
			//while: make account instance then account tostring
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
	public void closeAccount(Account a) {
		try(Connection connect = ConnectionUtil.getConnection();){
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	@Override
	public void updateJoin(User u) {
		DAO dao = new DaoImpl();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql2 = "insert into USER_ACCOUNT(user_id, account_id)"
					+ "values(?, ?)";
			PreparedStatement ps2 = connect.prepareStatement(sql2);
			ps2.setInt(1, u.getId());
			ps2.setInt(2, dao.getRecentAccount());
			int num = ps2.executeUpdate();
			System.out.println("Number of Rows Affected in User_Account: " + num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
