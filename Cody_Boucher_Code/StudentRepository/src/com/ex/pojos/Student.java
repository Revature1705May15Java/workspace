package com.ex.pojos;

import java.io.Serializable;

public class Student implements Serializable{
	String firstName;
	String lastName;
	String email;
	int id;
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String email, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + ":" + firstName + ":" + lastName + ":" + email + "\n";
	}

}
