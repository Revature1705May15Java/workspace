package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.RequestState;
import com.ers.util.ConnectionFactory;
import com.ers.util.RequestStatePool;

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

	@Override
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
	
	@Override
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
	
	@Override
	// TODO: Test
	public Employee updateEmployee(Employee employee) {
		Employee result = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE employee "
					+ "SET email = ?, "
					+ "password = ?, "
					+ "firstname = ?, "
					+ "lastname = ?, "
					+ "ismanager = ? "
					+ "WHERE employee_id = ?";
			
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
			ps.setInt(6, employee.getEmployeeId());
			
			int numUpdated = ps.executeUpdate();
			
			if(numUpdated == 1) {
				result = employee;
				result.setPassword(null);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> results = new ArrayList<Employee>();
		
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
	
	@Override
	// TODO: Test for null manager
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
				result = extractRequest(rs);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public List<Request> getAllRequests(RequestState state) {
		List<Request> results = new ArrayList<Request>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM request " +
					"WHERE state_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, state.getRequestId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = extractRequest(rs);
				
				results.add(r);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	@Override
	// TODO: Test
	public List<Request> getRequests(Employee employee) {
		// TODO: Consider making this null to check for sql exceptions
		List<Request> results = new ArrayList<Request>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM request "
					+ "WHERE employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getEmployeeId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Request r = extractRequest(rs);
				results.add(r);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	@Override
	public List<Request> getRequests(Employee employee, boolean isResolved) {
		List<Request> results = new ArrayList<Request>();
		
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
				Request r = extractRequest(rs);
				results.add(r);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	@Override
	// TODO: Test
	public Request updateRequest(Request request) {
		Request result = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{? = call updateRequest(?, ?, ?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(2, request.getRequestId());
			cs.setInt(3, request.getManager().getEmployeeId());
			cs.setInt(4, request.getState().getRequestId());
			cs.setString(5, request.getNote());
			
			cs.registerOutParameter(1, Types.DATE);
			
			cs.execute();
			
			Date closeDate = cs.getDate(1);
			
			if(closeDate != null) {
				result = request;
				result.setCloseDate(closeDate);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private Request extractRequest(ResultSet rs) throws SQLException {
		Request result = new Request();
		
		result.setRequestId(rs.getInt(1));
		result.setState(RequestStatePool.getState(RequestState.PENDING));
		result.setOpenDate(rs.getDate(3));
		result.setCloseDate(rs.getDate(4));
		result.setAmount(rs.getDouble(5));
		result.setPurpose(rs.getString(6));
		result.setRequester(getEmployee(rs.getInt(7)));
		result.setManager(getEmployee(rs.getInt(8)));
		result.setNote(rs.getString(9));
		
		return result;
	}
}
