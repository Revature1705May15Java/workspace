package com.ers.service;

import java.util.ArrayList;

import com.ers.dao.DAO;
import com.ers.dao.DAOImpl;
import com.ers.exceptions.InvalidPasswordException;
import com.ers.exceptions.NoSuchEmployeeException;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.RequestState;

public class Service {
	private DAO dao;
	
	/**
	 * Initializes the DAO.
	 */
	public Service() {
		dao = new DAOImpl();
	}
	
	/**
	 * Fetches the {@code Employee} with the given email address and determines
	 * if the given password is a match. If everything is correct, an object
	 * representing the employee is returned.
	 * 
	 * @param email		An employee's email address.
	 * @param password	An employee's password.
	 * @return	An {@code Employee} object that represents the employee.
	 * @throws NoSuchEmployeeException	If the given email address is not found in 
	 * 									persistent storage.
	 * @throws InvalidPasswordException	If the given password does not match the
	 * 									employee's password.
	 */
	public Employee login(String email, String password) 
			throws NoSuchEmployeeException, InvalidPasswordException{
		Employee employee = dao.getEmployee(email);
		
		if(employee == null) {
			throw new NoSuchEmployeeException("No such employee exists.");
		}
		else if(!employee.getPassword().equals(password)) {
			throw new InvalidPasswordException("Invalid password");
		}
		
		return employee;
	}
	
	/**
	 * Adds the given {@code Employee} to persistent storage.
	 * 
	 * @param employee	The employee that is to be persisted.
	 * @return	The given employee, or {@code null} if the information
	 * 			could not be persisted.
	 */
	public Employee addEmployee(Employee employee) {
		Employee result = dao.addEmployee(employee);
		
		if(result == null) {
			// TODO: Throw an exception
		}
		
		return result;
	}
	
	public ArrayList<Employee> getAllEmployees() {
		return (ArrayList<Employee>) dao.getAllEmployees();
	}
	
	public ArrayList<Request> getAllRequestsByState(RequestState state) {
		return (ArrayList<Request>) dao.getAllRequests(state);
	}
	
	public ArrayList<Request> getRequestsByState(Employee employee, boolean isResolved) {
		return (ArrayList<Request>) dao.getRequests(employee, isResolved);
	}
	
	// TODO: Test
	public ArrayList<Request> getRequestsByEmployee(Employee employee) {
		return (ArrayList<Request>) dao.getRequests(employee);
	}
	
	public Request submitRequest(Request request) {
		Request result = dao.addRequest(request);
				
		return result;
	}
	
	// TODO: Test
	public Employee updateEmployee(Employee employee) {
		Employee result = dao.updateEmployee(employee);
		
		if(result == null) {
			// TODO: Throw exception if update was unsuccessful.
		}
		
		return result;
	}
	
	// TODO: Test
	public Request updateRequest(Request request) {
		Request result = dao.updateRequest(request);
		
		if(result == null) {
			// TODO: Throw exception when update is unsuccessful
		}
		
		return result;
	}
	
	public Request getRequest(int id) {
		return dao.getRequest(id);
	}
	
	public Employee getEmployee(int id) {
		return dao.getEmployee(id);
	}
	
	public boolean isEmailUnique(String email) {
		if(dao.getEmployee(email) == null) {
			return true;
		}
		
		return false;
	}
}
