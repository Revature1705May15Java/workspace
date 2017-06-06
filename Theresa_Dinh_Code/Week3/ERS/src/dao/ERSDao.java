package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ersUtil.ConnectionFactory;
import pojos.Employee;

public class ERSDao 
{
	public ERSDao()
	{
		super(); 
	}
	
	public Employee getEmployee(Employee employee) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String s = "SELECT * FROM EMPLOYEE WHERE EMAIL = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, employee.getEmail());
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// email, password, firstname, lastname, ismanager 
				Employee temp = new Employee(); 
				temp.setEmail(rs.getString(1));
				temp.setPassword(rs.getString(2));
				temp.setFirstName(rs.getString(3));
				temp.setLastName(rs.getString(4));
				temp.setManagerId(rs.getInt(5));
			
				return temp; 
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
		} 
		return null;
	}
	
	public Employee getEmployee(String email) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String s = "SELECT * FROM EMPLOYEE WHERE EMAIL = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// email, password, id, firstname, lastname, ismanager 
				Employee temp = new Employee(); 
				temp.setEmail(rs.getString(1));
				temp.setPassword(rs.getString(2));
				temp.setId(rs.getInt(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setManagerId(rs.getInt(6));
			
				return temp; 
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		return null;
	}
	
}