package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.pojos.Employee;
import com.ers.util.ConnectionFactory;

public class DaoImp implements DAO 
{
	
	public Employee getEmployee(String email)
	{
		
		Employee e = new Employee();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "select * from employee where email = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				e.setEmployeeId(info.getInt(1));
				e.setfName(info.getString(2));
				e.setlName(info.getString(3));
				e.setIsManager(info.getInt(4));
				e.setEmail(info.getString(5));
				e.setPass(info.getString(6));
			}
			
			
			if(email == null)
			{
				e.setEmployeeId(0);
			}
			
			return e;
		} 
		catch (SQLException sq) 
		{
			// TODO Auto-generated catch block
			sq.printStackTrace();
		}
		
		System.out.println("ERROR");
		e.setEmployeeId(0);
		return e;
	}

}
