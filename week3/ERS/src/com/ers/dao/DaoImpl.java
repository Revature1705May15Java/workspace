package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.pojos.Employee;
import com.ers.util.ConnectionFactory;

public class DaoImpl implements DAO {
	
	@Override
	public int addEmployee(String uname, String pw,String fn, String ln, int isManager) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "insert into employee(USERNAME, PW, FIRSTNAME, LASTNAME, ISMANAGER"
					+ "values(?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setInt(4, isManager);
			int num = ps.executeUpdate();
			System.out.println(num+" users added");
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Employee getEmployee(String username) {
		Employee e = new Employee();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM EMPLOYEEE WHERE (username)=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet empinfo = ps.executeQuery();
			while(empinfo.next()){
				e.setUsername(empinfo.getString(1));
				e.setPassword(empinfo.getString(2));
				e.setEid(empinfo.getInt(3));
				e.setFirstname(empinfo.getString(4));
				e.setLastname(empinfo.getString(5));
				e.setIsmanager(empinfo.getInt(6));
			}
			return e;
				
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		return null;
			
			
		}
			
			
		

	}


