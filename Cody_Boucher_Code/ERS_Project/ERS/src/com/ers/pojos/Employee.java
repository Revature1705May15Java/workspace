package com.ers.pojos;

public class Employee {
	private String username;
	private String password;
	private int id;
	private String firstName;
	private String lastName;
	private boolean isManager;
	
	public Employee() {
		super();
	}

	public Employee(String username, String password, int id, String firstName, String lastName, boolean isManager) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isManager = isManager;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", isManager=" + isManager + "]";
	}
	
}
