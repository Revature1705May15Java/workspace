package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	@Override
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from employee";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet info = ps.executeQuery();
			
			//id email password fn ln ismanager
			while(info.next()){
				Employee e = new Employee();
				e.setId(info.getInt(1));
				e.setEmail(info.getString(2));
				e.setPassword(info.getString(3));
				e.setFirstName(info.getString(4));
				e.setLastName(info.getString(5));
				e.setIsManager(info.getInt(6));
				employees.add(e);
			}
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
