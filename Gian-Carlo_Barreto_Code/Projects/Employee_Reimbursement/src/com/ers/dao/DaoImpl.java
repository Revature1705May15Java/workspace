package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.StateType;
import com.ers.util.ConnectionFactory;

/**
 * Used to manipulate the ERS database
 * @author Gian-Carlo
 *
 */
public class DaoImpl implements DAO {
	
	/**
	 * Get the Employee with the specified email and password
	 * @param email, employee's email
	 * @param password, employee's password
	 * @return the Employee
	 */
	@Override
	public Employee getEmployee(String email, String password) {
		Employee emp = null;
		
		// Creates a Connection to the database;
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL statement for getting a specific Employee
			//String sql = "SELECT * FROM Employee WHERE email = ? AND password = ?";
			String sql = "SELECT * FROM Employee WHERE email = ?";
			
			// Creates a PreparedStatement object for sending the SQL statement to the database
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ps.setString(1, email);
			//ps.setString(2, password);
			
			// Set the attributes of the employee using the result from the sql query
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				emp = new Employee();
				emp.setEmployeeId(info.getInt(1));
				emp.setFirstName(info.getString(2));
				emp.setLastName(info.getString(3));
				emp.setEmail(info.getString(4));
				emp.setPassword(info.getString(5));
				if (info.getInt(6) == 0)
					emp.setManager(false);
				else
					emp.setManager(true);
			}
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Creates a request
	 * @param empId, the employee's id
	 * @param amount, the amount of the request
	 * @param purpose, the purpose for the request
	 * @return the created Request
	 */
	@Override
	public Request addRequest(int empId, double amount, String purpose) {
		Request req = new Request();
		
		// Creates a connection to the database
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL statement for adding a request
			String sql = "INSERT INTO Request (emp_id, amount, purpose)"
						+ "VALUES (?, ?, ?)";
			String generatedColumns[] = { "req_id" };
			
			// Creates a PreparedStatement object for sending the SQL statement to the database
			PreparedStatement ps = connect.prepareStatement(sql, generatedColumns);
			ps.setInt(1, empId);
			ps.setDouble(2, amount);
			ps.setString(3, purpose);
			
			// Sets the fields of the request
			int row = ps.executeUpdate();
			if (row == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					req.setRequestId(rs.getInt(1));
					req.setEmployeeId(empId);
					req.setType(StateType.PENDING);
					req.setAmount(amount);
					req.setOpenDate(LocalDate.now());
					req.setPurpose(purpose);
				}
			}
			return req;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets all the requests of a specific employee
	 * @param empId, the employee's id
	 * @return a list of requests
	 */
	@Override
	public ArrayList<Request> getEmployeeRequests(int empId) {
		ArrayList<Request> requests = new ArrayList<Request>();
		
		// Creates a connection to the database
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL query for getting all of the employee's requests
			String sql = "SELECT * FROM Request WHERE emp_id = ?";
			
			// Creates a PreparedStatement object for sending the SQL statement to the database
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, empId);
			
			// Results from the SQL query
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				Request req = new Request();
				req.setRequestId(info.getInt(1));
				req.setEmployeeId(info.getInt(2));
				int state = info.getInt(3);
				if (state == 1)
					req.setType(StateType.PENDING);
				else if (state == 2)
					req.setType(StateType.APPROVED);
				else
					req.setType(StateType.DENIED);
				req.setAmount(info.getDouble(4));
				req.setOpenDate(info.getDate(5).toLocalDate());
				if (info.getDate(6) != null)
					req.setCloseDate(info.getDate(6).toLocalDate());
				else
					req.setCloseDate(null);
				req.setPurpose(info.getString(7));
				req.setManagerId(info.getInt(8));
				req.setManagerNote(info.getString(9));
				requests.add(req);
			}
			return requests;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets an employee by id
	 * @param empId, the employee's id
	 * @return the employee
	 */
	@Override
	public Employee getEmployeeById(int empId) {
		Employee emp = null;
		
		// Creates a Connection to the database;
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL statement for getting a specific Employee
			String sql = "SELECT * FROM Employee WHERE emp_id = ?";
			
			// Creates a PreparedStatement object for sending the SQL statement to the database
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ps.setInt(1, empId);
			
			// Set the attributes of the employee using the result from the sql query
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				emp = new Employee();
				emp.setEmployeeId(info.getInt(1));
				emp.setFirstName(info.getString(2));
				emp.setLastName(info.getString(3));
				emp.setEmail(info.getString(4));
				emp.setPassword(info.getString(5));
				if (info.getInt(6) == 0)
					emp.setManager(false);
				else
					emp.setManager(true);
			}
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Updates an employee's information
	 * @param empId, the employee's id
	 * @param firstName, the employee's first name
	 * @param lastName, the employee's last naem
	 * @param email, the employee's email
	 * @return true if update was successful false otherwise;
	 */
	@Override
	public boolean updateEmployee(int empId, String firstName, String lastName, String email) {
		// Creates a connection to the database
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL statement for updating an employee
			String sql = "UPDATE Employee SET first_name = ?, last_name = ?, email = ? WHERE emp_id = ?";
			
			// Creates a PreparedStatement object for sending the SQL statement to the database
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setInt(4, empId);
			
			// Checks to see if the employee was updated
			int row = ps.executeUpdate();
			if (row == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		// Creates a connection to the database
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL query for getting all of the employee's requests
			String sql = "SELECT * FROM Employee";
			
			// Creates a Statement object for sending the SQL statement to the database
			Statement stmt = connect.createStatement();
			
			// Executes the query and gets all the selected records and adds them to
			// the employees ArrayList
			ResultSet info = stmt.executeQuery(sql);
			while (info.next()) {
				Employee e = new Employee();
				e.setEmployeeId(info.getInt(1));
				e.setFirstName(info.getString(2));
				e.setLastName(info.getString(3));
				e.setEmail(info.getString(4));
				e.setPassword(info.getString(5));
				if (info.getInt(6) == 0)
					e.setManager(false);
				else
					e.setManager(true);
				employees.add(e);
			}
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get all of the requests
	 * @return list of requests
	 */
	@Override
	public ArrayList<Request> getAllRequests() {
		ArrayList<Request> requests = new ArrayList<Request>();
		
		// Creates a connection to the database
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL query for getting all of the employee's requests
			String sql = "SELECT * FROM Request";
			
			// Creates a Statement object for sending the SQL statement to the database
			Statement stmt = connect.createStatement();
			
			// Executes the query and gets all the selected records and adds them to
			// the requests ArrayList
			ResultSet info = stmt.executeQuery(sql);
			while (info.next()) {
				Request req = new Request();
				req.setRequestId(info.getInt(1));
				req.setEmployeeId(info.getInt(2));
				int state = info.getInt(3);
				if (state == 1)
					req.setType(StateType.PENDING);
				else if (state == 2)
					req.setType(StateType.APPROVED);
				else
					req.setType(StateType.DENIED);
				req.setAmount(info.getDouble(4));
				req.setOpenDate(info.getDate(5).toLocalDate());
				if (info.getDate(6) != null)
					req.setCloseDate(info.getDate(6).toLocalDate());
				else
					req.setCloseDate(null);
				req.setPurpose(info.getString(7));
				req.setManagerId(info.getInt(8));
				req.setManagerNote(info.getString(9));
				requests.add(req);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Closes a request
	 * @param reqId, the request's id
	 * @param state, the state type
	 * @param managerId, the manager's id
	 * @param managerNote, the manager's note
	 * @return true if request was closed successfully, false otherwise
	 */
	@Override
	public boolean closeRequest(int reqId, int state, int managerId, String managerNote) {
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			 String sql = "{call close_request(?, ?, ?, ?)}";
			
			CallableStatement cs = connect.prepareCall(sql);
			cs.setInt(1, reqId);
			cs.setInt(2, state);
			cs.setInt(3, managerId);
			cs.setString(4, managerNote);
			
			int row = cs.executeUpdate();
			if (row == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Get all of the pending requests
	 * @return list of pending requests
	 */
	@Override
	public ArrayList<Request> getPendingRequests() {
		ArrayList<Request> requests = new ArrayList<Request>();
		
		// Creates a connection to the database
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL query for getting all of the employees' pending requests
			String sql = "SELECT * FROM Request WHERE state_id = 1";
			
			// Creates a Statement object for sending the SQL statement to the database
			Statement stmt = connect.createStatement();
			
			// Executes the query and gets all the selected records and adds them to
			// the requests ArrayList
			ResultSet info = stmt.executeQuery(sql);
			while (info.next()) {
				Request req = new Request();
				req.setRequestId(info.getInt(1));
				req.setEmployeeId(info.getInt(2));
				req.setType(StateType.PENDING);
				req.setAmount(info.getDouble(4));
				req.setOpenDate(info.getDate(5).toLocalDate());
				if (info.getDate(6) != null)
					req.setCloseDate(info.getDate(6).toLocalDate());
				else
					req.setCloseDate(null);
				req.setPurpose(info.getString(7));
				req.setManagerId(info.getInt(8));
				req.setManagerNote(info.getString(9));
				requests.add(req);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get all of the resolved requests
	 * @return list of resolved request
	 */
	@Override
	public ArrayList<Request> getResolvedRequest() {
		ArrayList<Request> requests = new ArrayList<Request>();
		
		// Creates a connection to the database
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL query for getting all of the employees' resolved requests
			String sql = "SELECT * FROM Request WHERE state_id = 2 OR state_id = 3";
			
			// Creates a Statement object for sending the SQL statement to the database
			Statement stmt = connect.createStatement();
			
			// Executes the query and gets all the selected records and adds them to
			// the requests ArrayList
			ResultSet info = stmt.executeQuery(sql);
			while (info.next()) {
				Request req = new Request();
				req.setRequestId(info.getInt(1));
				req.setEmployeeId(info.getInt(2));
				int state = info.getInt(3);
				if (state == 2)
					req.setType(StateType.APPROVED);
				else if (state == 3)
					req.setType(StateType.DENIED);
				req.setAmount(info.getDouble(4));
				req.setOpenDate(info.getDate(5).toLocalDate());
				if (info.getDate(6) != null)
					req.setCloseDate(info.getDate(6).toLocalDate());
				else
					req.setCloseDate(null);
				req.setPurpose(info.getString(7));
				req.setManagerId(info.getInt(8));
				req.setManagerNote(info.getString(9));
				requests.add(req);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
