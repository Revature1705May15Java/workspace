package com.rev.pojos;

import java.util.ArrayList;

// TODO: Add comments
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
	private ArrayList<Account> accounts;

	public User() {
		
	}
	
	public User(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	// TODO: Clean up output
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", accounts=" + accounts + "]";
	}
	
	
}
