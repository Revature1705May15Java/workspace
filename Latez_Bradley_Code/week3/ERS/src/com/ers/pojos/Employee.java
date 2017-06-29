package com.ers.pojos;

public class Employee {
	String username, password, firstname, lastname;
	int eid, ismanager;
	
	
	
	public Employee() {
		super();
	}
	
	public Employee(String username, String password, String firstname, String lastname, int ismanager) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.ismanager = ismanager;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", eid=" + eid + ", ismanager=" + ismanager + "]";
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getIsmanager() {
		return ismanager;
	}
	public void setIsmanager(int ismanager) {
		this.ismanager = ismanager;
	}






	

}
