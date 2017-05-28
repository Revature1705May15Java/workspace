package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class DaoImpl implements DAO {
	static Logger logger = new Logger();

	
	
	@Override
	public int addUser(String fn, String ln, String pw, String uname){
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "insert into users(first_name, last_name, password, username) " +
					"values(?, ?, ?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pw);
			ps.setString(4, uname);
			
			int num = ps.executeUpdate();
			
			logger.log(num + " users add");
			return num;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return 0;
	}

	@Override
	public int updateBalance(Account account, double newbal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUser(String uname) {
		// TODO Auto-generated method stub
		User u = new User();
		uname = uname.toLowerCase();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from users where lower(username) = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, uname.toLowerCase());
			
			ResultSet userinfo = ps.executeQuery();
			//id, fn, ln, pw, uname
			
			while(userinfo.next()){
				u.setId(userinfo.getInt(1));
				u.setFn(userinfo.getString(2));
				u.setLn(userinfo.getString(3));
				u.setPw(userinfo.getString(4));
				u.setUname(userinfo.getString(5));
			}
			if(u.getUname()!=null){
			logger.log("Retrieved user by username " + u.toString());}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return null;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		
		User u = new User();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from users where u_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet userinfo = ps.executeQuery();
			//id, fn, ln, pw, uname
			
			while(userinfo.next()){
				u.setId(userinfo.getInt(1));
				u.setFn(userinfo.getString(2));
				u.setLn(userinfo.getString(3));
				u.setPw(userinfo.getString(4));
				u.setUname(userinfo.getString(5));
			}
			if(u.getUname()!=null){
			logger.log("Retrieved user by user id " + u.toString());}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return null;
	}


}