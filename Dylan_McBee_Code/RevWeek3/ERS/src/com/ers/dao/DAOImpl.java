package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.pojos.Employee;
import com.ers.util.ConnectionFactory;

public class DAOImpl implements DAO{

	Employee e = null;
	@Override
	public Employee getEmployee(String email) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			e = new Employee();
			String sql = "select * from employee where email = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			//id, email, password, fn, ln, isManager
			while(rs.next()){
				e.setId(rs.getInt(1));
				e.setEmail(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setFirstName(rs.getString(4));
				e.setLastName(rs.getString(5));
				e.setIsManager(rs.getInt(6));
			}
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
