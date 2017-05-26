package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class DaoImpl implements DAO{

	static Logger logger = new Logger();
	
	@Override
	public int updateBalance(Account account, double newBal) {
		return 0;
	}

	@Override
	public int addUser(String fn, String ln, String uName, String pw) {
		try (Connection connection = ConnectionUtil.getConnection();){
			String sql = "INSERT INTO USERS(first_name, last_name, password, username) values(?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pw);
			ps.setString(4, uName);
			
			int num = ps.executeUpdate();
			logger.log(num + " users added");
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User getUser(String uName) {
		User u = new User();
		try (Connection connection = ConnectionUtil.getConnection();){
			String sql = "select * from users where USERNAME = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uName.toLowerCase());
			ResultSet info = ps.executeQuery();

			
			//id fn ln pw uname
			while (info.next()) {
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPw(info.getString(4));
				u.setuName(info.getString(5));
			}
			
			if(u.getuName() !=null){
			logger.log("retrieved user by username: " + u.toString());}
			else{logger.log("User does not exist");
			return null;}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ERROR!");

		return null;
		
		
	}

	@Override
	public User getUser(int id) {
		return null;
	}
	
}
