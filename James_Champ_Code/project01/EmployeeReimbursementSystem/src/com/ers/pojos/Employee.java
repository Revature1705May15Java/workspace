package com.ers.pojos;

public class Employee {
	/**
	 * This employee's ID number.
	 */
	private int employeeId;
	/**
	 * This employee's first name.
	 */
	private String firstName;
	/**
	 * This employee's last name.
	 */
	private String lastName;
	/**
	 * This employee's email address.
	 */
	private String email;
	/**
	 * This employee's password.
	 */
	private String password;
	/**
	 * Indicates whether or not this employee is a manager.
	 */
	private boolean isManager;
	
	/**
	 * Creates a new {@code Employee} object default fields.
	 */
	public Employee() {
		super();
	}
	
	/**
	 * Creates a new {@code Employee} object with the given information.
	 * 
	 * @param employeeId	The employee's ID number.
	 * @param firstName		The employee's first name.
	 * @param lastName		The employee's last name.
	 * @param email			The employee's email address.
	 * @param password		The employee's password.
	 * @param isManager		Indicates whether the employee is a manager.
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
	 * Returns this employee's ID number.
	 * 
	 * @return	This employee's ID number.
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * Sets this employee's ID number to the given integer.
	 * 
	 * @param employeeId	This employee's new ID number.
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * Returns this employee's first name.
	 * 
	 * @return	String representing this employee's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Changes this employee's first name to the given string.
	 * 
	 * @param firstName	This employee's new first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns this employee's last name.
	 * 
	 * @return	String representation of this employee's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Changes this employee's last name to the given string.
	 * 
	 * @param lastName	This employee's new last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns this employee's email address.
	 * 
	 * @return	String representation of this employee's last name.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Changes this employee's email address to the given string.
	 * 
	 * @param email	This employee's new email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Returns this employee's password.
	 * 
	 * @return	This employee's password.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Changes this employee's password to the given string.
	 * 
	 * @param password	This employee's new password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Returns whether or not this employee is a manager.
	 * 
	 * @return	{@code true} if this employee is a manager, and
	 * 			{@code false} otherwise.
	 */
	public boolean getIsManager() {
		return isManager;
	}
	
	/**
	 * Changes an employee's manager status to the given boolean.
	 * 
	 * @param isManager	This employee's new manager status.
	 */
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}
}
