package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class DaoImp implements DAO
{

	static Logger logger = new Logger();
	
	
	@Override
	public int updateBalance(Account account, double amount) 
	{
		
		
		return 0;
	}

	@Override
	public int addUser(String fn, String ln, String email, String pass) 
	{
		
		try(Connection connection = ConnectionUtil.getConnection();)
		{
			
			String sql = " insert into users (fName, lName, password, email)"
						+ "values (?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pass);
			ps.setString(4, email);
			
			int num = ps.executeUpdate();
			
			logger.log(num + " users added");
			
			return num;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public User getUser(String email)
	{
		
		User u = new User();
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from users where email = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPw(info.getString(4));
				u.setEmail(info.getString(5));
			}
			
			if(u.getEmail()!= null)
				logger.log("retrived user by usernam" + u.toString());
			else
			{
				logger.log("Attempted to retrive non-existant user");
				return null;
			}
			
			return u;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ERROR");
		return null;
	}

	@Override
	public User getUser(int id) 
	{
		
		
		return null;
	}
	

}
