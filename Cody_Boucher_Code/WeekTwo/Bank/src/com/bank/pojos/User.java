package com.bank.pojos;

import java.util.ArrayList;

public class User {
	int id;
	String firstName;
	String lastName;
	String password;
	String username;
	ArrayList<Integer> userAccounts;
	
	public User() {}

	public User(int id, String firstName, String lastName, String password, String username, ArrayList<Integer> userAccounts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.userAccounts = userAccounts;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Integer> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(ArrayList<Integer> userAccounts) {
		this.userAccounts = userAccounts;
	}

	@Override
	public String toString() {
		return "User [id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", password = " + password
				+ ", username = " + username + ", userAccounts = " + userAccounts + "]";
	}
	
	
	
	
}
