package com.revature.pojos;

import java.io.Serializable;

public class Student implements Serializable
{
	String fname, lname, email;
	int id;

	public Student(String fname, String lname, String email, int id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	
	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", email=" + email + ", id=" + id + "]";
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

	
	public Student() 
	{
		
	}

}
