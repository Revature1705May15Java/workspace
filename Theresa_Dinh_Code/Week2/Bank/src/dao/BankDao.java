package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bankUtil.ConnectionUtil;
import pojos.Account;
import pojos.User;

public class BankDao implements Dao
{
	@Override
	public int updateBalance(Account account, double newBalance) 
	{
		try(Connection c = ConnectionUtil.getConnection())
		{
			String statement = ""; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public User addUser(String fn, String ln, String pw, String email) 
	{
		try(Connection c = ConnectionUtil.getConnection();)
		{
			String s = "INSERT INTO Users (FNAME, LNAME, PASSWORD, EMAIL)"
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pw);
			ps.setString(4, email);
			
			int rowCheck = ps.executeUpdate(s); 
			System.out.println(rowCheck);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public User addUser(User newUser) 
	{
		try(Connection c = ConnectionUtil.getConnection();)
		{
			String s = "INSERT INTO USERS VALUES(?, ?, ?, ?, ?)";
//			PreparedStatement ps = ; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(int id) 
	{
		try(Connection c = ConnectionUtil.getConnection();)
		{
			String s = "SELECT * FROM USERS WHERE USERID = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// userid, fname, lname, password, email
				User u = new User(); 
				u.setId(rs.getInt(1));
				u.setfName(rs.getString(2)); 
				u.setlName(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setEmail(rs.getString(5));
				return u; 
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		return null;
	}

	public User getUser(String email) 
	{
		try(Connection c = ConnectionUtil.getConnection();)
		{
			String s = "SELECT * FROM USERS WHERE USERID = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// userid, fname, lname, password, email
				User u = new User(); 
				u.setId(rs.getInt(1));
				u.setfName(rs.getString(2)); 
				u.setlName(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setEmail(rs.getString(5));
				return u; 
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		return null;
	}
}