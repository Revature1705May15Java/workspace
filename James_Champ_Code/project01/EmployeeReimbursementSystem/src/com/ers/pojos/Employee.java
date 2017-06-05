package com.ers.pojos;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isManager;
	
	public Employee() {
		super();
	}
	
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

	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isManager() {
		return isManager;
	}
	
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}
}
