package com.ex.model;

public class Customer {

	private String firstname;
	private String lastname;
	// default constructor is used here
	// constructor injection will use 
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
	
	
}
