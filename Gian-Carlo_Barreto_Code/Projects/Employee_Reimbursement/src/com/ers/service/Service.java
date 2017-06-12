package com.ers.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.ers.dao.DAO;
import com.ers.dao.DaoImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.StateType;

/**
 * This class is the "proxy" that helps the client communicate with the database and helps
 * the database communicate with the client
 * @author Gian-Carlo
 *
 */
public class Service {
	private DAO dao;
	
	/*
	 * No-arg constructor that creates an instance of the DAO
	 */
	public Service() {
		this.dao = new DaoImpl();
	}
	
	/**
	 * Confirms the employee's login information
	 * @param email, employee's email
	 * @param password, employee's password
	 * @return the employee's information
	 */
	public Employee confirmLogin(String email, String password) {
		return this.dao.getEmployee(email, password);
	}
	
	/**
	 * Creates a request for the specific employee
	 * @param empId, the employee's id
	 * @param amount, the amount requested for reimbursement
	 * @param purpose, the purpose for the request
	 * @return the request
	 */
	public Request createRequest(int empId, double amount, String purpose) {
		return this.dao.addRequest(empId, amount, purpose);
	}
	
	/**
	 * Get all of the employee's requests
	 * @param empId, the employee's id
	 * @return list of employee's requests
	 */
	public ArrayList<Request> getEmployeeRequests(int empId) {
		return this.dao.getEmployeeRequests(empId);
	}
	
	/**
	 * Gets an employee by id
	 * @param empId, the employee's id
	 * @return the employee
	 */
	public Employee getEmployeeById(int empId) {
		return this.dao.getEmployeeById(empId);
	}
	
	/**
	 * Updates and employee's information
	 * @param empId, the employee's id
	 * @param firstName, the employee's first name
	 * @param lastName, the employee's last name
	 * @param email, the employee's email
	 * @return true if update was successful, false otherwise
	 */
	public boolean updateEmployee(int empId, String firstName, String lastName, String email) {
		return this.dao.updateEmployee(empId, firstName, lastName, email);
	}
	
	/**
	 * Checks to see if an eamil has been used
	 * @param email, the email to be checked
	 * @return true if the email is available, false otherwise
	 */
	public boolean isEmailAvailable(String email) {
		ArrayList<Employee> employees = this.dao.getAllEmployees();
		boolean available = true;
		for (Employee e : employees) {
			if (email.equals(e.getEmail())) {
				available = false;
				break;
			}
		}
		return available;
	}
	
	/**
	 * Get all of the employees
	 * @return list of employees
	 */
	public ArrayList<Employee> getAllEmployees() {
		return this.dao.getAllEmployees();
	}
	
	/**
	 * Get all of the requests
	 * @return list of requests
	 */
	public ArrayList<Request> getAllRequests() {
		return this.dao.getAllRequests();
	}
	
	/**
	 * Close a request
	 * @param r, the request to be closed
	 * @return true if request was closed successfully, false otherwise
	 */
	public boolean closeRequest(Request r) {
		int state = 0;
		if (r.getType() == StateType.APPROVED)
			state = 2;
		else if (r.getType() == StateType.DENIED)
			state = 3;
		if (this.dao.closeRequest(r.getRequestId(), state, r.getManagerId(), r.getManagerNote())) {
			r.setCloseDate(LocalDate.now());
			return true;
		}
		return false;
	}
	
	/**
	 * Get all of the pending requests
	 * @return list of pending requests
	 */
	public ArrayList<Request> getAllPendingRequest() {
		return this.dao.getPendingRequests();
	}
	
	/**
	 * Get all of the resolved requests
	 * @return list of resolved request
	 */
	public ArrayList<Request> getAllResolvedRequest() {
		return this.dao.getResolvedRequest();
	}
}
