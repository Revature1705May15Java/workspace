package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.RequestState;
import com.ers.util.ConnectionFactory;

public class DAOImpl implements DAO{
	private static final int IS_MANAGER = 1;
	private static final int IS_NOT_MANAGER = 0;
	
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

	public Employee getEmployee(int id) {
		Employee result = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM employee " 
					+ "WHERE employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new Employee();
				
				result.setEmployeeId(rs.getInt(1));
				result.setEmail(rs.getString(2));
				// TODO: Consider *not* setting the password...
				result.setPassword(rs.getString(3));
				result.setFirstName(rs.getString(4));
				result.setLastName(rs.getString(5));
				
				if(rs.getInt(6) == 1) {
					result.setIsManager(true);
				}
				else {
					result.setIsManager(false);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Employee addEmployee(Employee employee) {
		Employee result = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO employee (email, password, firstname, lastname, ismanager) "
					+ "VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEmail());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getFirstName());
			ps.setString(4, employee.getLastName());
			
			if(employee.getIsManager()) {
				ps.setInt(5, IS_MANAGER);
			}
			else {
				ps.setInt(5, IS_NOT_MANAGER);
			}
			
			int rowsAdded = ps.executeUpdate();
			if(rowsAdded == 1) {
				return employee;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> results = new ArrayList<Employee>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM employee";
			
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Employee e = new Employee();
				
				e.setEmployeeId(rs.getInt(1));
				e.setEmail(rs.getString(2));
				// TODO: Password should probably be null
				e.setPassword(rs.getString(3));
				e.setFirstName(rs.getString(4));
				e.setLastName(rs.getString(5));
				
				int isManager = rs.getInt(6);
				if(isManager == 1) {
					e.setIsManager(true);
				}
				else {
					e.setIsManager(false);
				}
				
				results.add(e);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	public Request addRequest(Request request) {
		Request result = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{? = call addRequest(?, ?, ?)}";
			int id;
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, request.getRequester().getEmployeeId());
			cs.setDouble(3, request.getAmount());
			cs.setString(4, request.getPurpose());
			
			cs.execute();
			id = cs.getInt(1);
			
			sql = "SELECT * FROM request WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result = new Request();
				
				result.setRequestId(rs.getInt(1));
				result.setState(new RequestState(RequestState.PENDING));
				result.setOpenDate(rs.getDate(3));
				result.setCloseDate(rs.getDate(4));
				result.setAmount(rs.getDouble(5));
				result.setPurpose(rs.getString(6));
				result.setRequester(request.getRequester());
				result.setManager(null);
				result.setNote(rs.getString(9));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Request> getAllRequests(RequestState state) {
		ArrayList<Request> results = new ArrayList<Request>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM request " +
					"WHERE state_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, state.getRequestId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				r.setRequestId(rs.getInt(1));
				r.setState(new RequestState(rs.getInt(2)));
				r.setOpenDate(rs.getDate(3));
				r.setCloseDate(rs.getDate(4));
				r.setAmount(rs.getDouble(5));
				r.setPurpose(rs.getString(6));
				r.setRequester(getEmployee(rs.getInt(7)));
				r.setManager(getEmployee(rs.getInt(8)));
				r.setNote(rs.getString(9));
				
				results.add(r);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	public ArrayList<Request> getRequests(Employee employee, boolean isResolved) {
		ArrayList<Request> results = new ArrayList<Request>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM request "
					+ "WHERE employee_id = ? AND state_id ";
			
			if(isResolved) {
				sql += "!= 1";
			}
			else {
				sql += "= 1";
			}
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getEmployeeId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = new Request();
				r.setRequestId(rs.getInt(1));
				r.setState(new RequestState(rs.getInt(2)));
				r.setOpenDate(rs.getDate(3));
				r.setCloseDate(rs.getDate(4));
				r.setAmount(rs.getDouble(5));
				r.setPurpose(rs.getString(6));
				r.setRequester(getEmployee(rs.getInt(7)));
				r.setManager(getEmployee(rs.getInt(8)));
				r.setNote(rs.getString(9));
				
				results.add(r);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
}
