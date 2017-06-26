package com.ex.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Defines the information about an employee
 * @author Gian-Carlo
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	// Setting up hibernate annotations
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="empSeq")
	@SequenceGenerator(allocationSize=1, name="empSeq", sequenceName="EMP_SEQ")
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="IS_MANAGER")
	private boolean isManager;
	
	/**
	 * No-arg constructor needed for a bean
	 */
	public Employee() {}
	
	public Employee(String firstName, String lastName, String email, String password,
			boolean isManager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isManager = isManager;
	}
	
	/**
	 * Creates an instance of an Employee
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
	 * @return employee id
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee's id
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Checks to see if an employee is a manager
	 * @return true if manager, false otherwise
	 */
	public boolean isManager() {
		return isManager;
	}

	/**
	 * Sets the managerial status of an employee
	 * @param isManager
	 */
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	/**
	 * String representation of the Employee object
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", isManager=" + isManager + "]";
	}
}
