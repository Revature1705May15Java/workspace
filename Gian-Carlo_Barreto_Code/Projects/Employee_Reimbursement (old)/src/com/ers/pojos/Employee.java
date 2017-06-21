package com.ers.pojos;

import java.util.ArrayList;

/**
 * Contains the information of an employee. 
 * @author Gian-Carlo
 *
 */
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isManager;
	private ArrayList<Request> requests;
	
	/**
	 * No-arg constructor
	 */
	public Employee() {
		super();
		this.employeeId = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
		this.isManager = false;
	}
	
	/**
	 * All fields constructor
	 * @param employeeId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param isManager
	 */
	public Employee(int employeeId, String firstName, String lastName, String email, String password,
			boolean isManager) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isManager = isManager;
	}

	/**
	 * Gets the employee's id
	 * @return the employee's id
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee's id
	 * @param employeeId, the employee's id
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the employee's first name
	 * @return the employee's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the employee's first name
	 * @param firstName, the employee's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the employee's last name
	 * @return the employee's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the employee's last name
	 * @param lastName, the employee's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the employee's email
	 * @return the employee's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the employee's email
	 * @param email, the employee's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the employee's password
	 * @return the employee's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the employee's password
	 * @param password, the employee's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Checks to see if the employee is a manager
	 * @return true if employee is a manager, false otherwise
	 */
	public boolean isManager() {
		return isManager;
	}

	/**
	 * Sets the employee's manager status
	 * @param isManager, true if employee is a manager, false otherwise
	 */
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	/**
	 * Gets a list of all of the employee's request
	 * @return list of employee's request
	 */
	public ArrayList<Request> getRequests() {
		return requests;
	}

	/**
	 * Sets the list of requests
	 * @param requests, list of request
	 */
	public void setRequests(ArrayList<Request> requests) {
		this.requests = requests;
	}

	/**
	 * Returns a string representation of the Employee
	 * @return string representation of the Employee
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", isManager=" + isManager + ", requests=" + requests + "]";
	}
}
