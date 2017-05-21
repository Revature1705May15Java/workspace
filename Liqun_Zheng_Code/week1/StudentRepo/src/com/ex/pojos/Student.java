package com.ex.pojos;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * all class variables
	 */
	private static final long serialVersionUID = 1L;
	String firstName, lastName, email;
	int id;
	
	
	public Student(){
	}
	// Override default constructor 
	public Student(String firstName, String lastName, String email, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
	}
	
	
	//geter and setter for each variables
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//Overrides toString method
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", id=" + id + "]\n";
	}
	
}
