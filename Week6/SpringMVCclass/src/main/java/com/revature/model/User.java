package com.revature.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

	
	@NotEmpty(message="Please enter a username")
	@Size(min=4, max=20)
	private String username;
	@NotEmpty
	private String password;
	
	public User(){}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}
