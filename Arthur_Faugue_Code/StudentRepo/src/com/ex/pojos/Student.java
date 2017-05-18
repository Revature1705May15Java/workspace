package com.ex.pojos;

import java.io.Serializable;

public class Student implements Serializable{

	String FirstName, lastName, email;
	int id;
	
	public Student(){
		
	}
	public Student(String firstName, String lastName, String email, int id) {
		super();
		FirstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Student [FirstName=" + FirstName + ", lastName=" + lastName + ", email=" + email + ", id=" + id + "]";
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
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
	
	
}
