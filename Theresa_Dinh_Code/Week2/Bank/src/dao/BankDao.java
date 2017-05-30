package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import bankUtil.ConnectionUtil;
import pojos.Account;
import pojos.User;

// reads and writes to sql database 

public class BankDao implements Dao
{
	@Override
	public double viewBalance(Account account) 
	{
		try(Connection c = ConnectionUtil.getConnection();)
		{
			String statement = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNTID = ?";
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setInt(1, account.getId());

			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				return rs.getDouble(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace(); 
		}
		return -0.00;	//how to tell when viewBalance fails??
	}

	@Override
	public double updateBalance(Account account, double newBalance) 
	{
		try(Connection c = ConnectionUtil.getConnection();)
		{
			String statement = "UPDATE ACCOUNT "
					+ "SET BALANCE = ?"
					+ "WHERE ACCOUNTID = ?; "; 
			PreparedStatement ps = c.prepareStatement(statement); 
			ps.setDouble(1, newBalance); 
			ps.setInt(2, account.getId());
			
			int rowCheck = ps.executeUpdate(statement); 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return 0;
	}

	// not all variables bound - id trigger not working???
	@Override
	public User addUser(String fn, String ln, String pw, String email) 
	{
		try(Connection c = ConnectionUtil.getConnection();)
		{
			String statement = "INSERT INTO Users (FNAME, LNAME, PASSWORD, EMAIL)"
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pw);
			ps.setString(4, email);
			
			int rowCheck = ps.executeUpdate(statement); 
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
			String statement = "INSERT INTO USERS VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setString(1, newUser.getfName());
			ps.setString(2, newUser.getlName());
			ps.setString(3, newUser.getPassword());
			ps.setString(4, newUser.getEmail());
			
			int rowCheck = ps.executeUpdate(); 
			System.out.println(rowCheck);
			return newUser; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	// screw Date, using Timestamp 
	// ???????????????????????????
	@Override
	public boolean createAccount(Account account)
	{
		try(Connection c = ConnectionUtil.getConnection();)
		{
			String statement = "INSERT INTO ACCOUNT (BALANCE, TYPEID, OPENDATE, CLOSEDATE)"
					+ "VALUES (?, ?, ?, ?)"; 
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setInt(1, account.getId());
			ps.setInt(2, (account.getType()).getId());
			ps.setTimestamp(3, account.getDateOpened());
			ps.setTimestamp(4, null);
			
			int rowCheck = ps.executeUpdate();
			if(rowCheck != 1)
				return false; 
			else 
				return true; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false; 
	}
	
	//HOW DO DATEEEEEEEEEEEEEEE
	// only add closeDate without actually deleting record
	@Override
	public boolean deleteAccount(Account account)
	{
		try(Connection c = ConnectionUtil.getConnection();)
		{
			String statement = "UPDATE ACCOUNT SET CLOSEDATE = ? WHERE ACCOUNTID = ?"; 
			PreparedStatement ps = c.prepareStatement(statement);
			/////
			
			int rowCheck = ps.executeUpdate();
			if(rowCheck != 1)
				return false; 
			else 
				return true; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false; 
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

	@Override
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
