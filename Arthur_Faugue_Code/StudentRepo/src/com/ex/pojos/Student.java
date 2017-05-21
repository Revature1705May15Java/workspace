package com.ex.pojos;

import java.io.Serializable;

public class Student implements Serializable{

	/*
	 * Initialize the data types that will be used in the 
	 * Student object.
	 */
	private static final long serialVersionUID = 1L;
	String FirstName, lastName, email;
	int id;
	
	/*
	 * User defined constructor with no arguments
	 */
	public Student(){
		
	}
	
	/*
	 * User defined constructor that creates an Student object with
	 * it data types
	 */
	public Student(String firstName, String lastName, String email, int id) {
		super();
		FirstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
	}
	
	/*
	 * Returns the data contained in the Student object to the console
	 */
	@Override
	public String toString() {
		return "Student [FirstName=" + FirstName + ", lastName=" + lastName + ", email=" + email + ", id=" + id + "]";
	}
	
	/*
	 * Returns the first name of the Student object
	 */
	public String getFirstName() {
		return FirstName;
	}
	
	/*
	 * Sets the first name given to the Student object
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	/*
	 * Returns the last name of the Student object
	 */
	public String getLastName() {
		return lastName;
	}
	
	/*
	 * Sets the last name given to the Student object
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*
	 * Returns the email of the Student object
	 */
	public String getEmail() {
		return email;
	}
	
	/*
	 * Sets the email given to the Student object
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * Returns the student ID of the Student object
	 */
	public int getId() {
		return id;
	}
	
	/*
	 * Sets the student ID given to the Student object
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
}
