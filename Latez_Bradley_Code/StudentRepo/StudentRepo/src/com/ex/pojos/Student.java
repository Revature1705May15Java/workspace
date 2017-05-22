package com.ex.pojos;

import java.io.Serializable;

public class Student implements Serializable {
	String firstName, lastName, email;
	int id;
	
	public String getFristName() {
		return firstName;
	}

	public void setFristName(String fristName) {
		this.firstName = fristName;
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

	public Student(String fristName, String lastName, String email, int id) {
		super();
		this.firstName = fristName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", id=" + id + "]";
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
	

}
