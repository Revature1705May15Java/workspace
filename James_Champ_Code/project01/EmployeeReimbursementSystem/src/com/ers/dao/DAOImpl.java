package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.pojos.Employee;
import com.ers.util.ConnectionFactory;

public class DAOImpl implements DAO{

	@Override
	public Employee getEmployee(String email) {
		Employee employee = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM employee WHERE email = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmail(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setFirstName(rs.getString(4));
				employee.setLastName(rs.getString(5));

				int isManager = rs.getInt(6);
				if(isManager == 1) {
					employee.setIsManager(true);
				}
				else {
					employee.setIsManager(false);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

}
