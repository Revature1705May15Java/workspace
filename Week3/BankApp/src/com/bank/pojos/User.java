package com.bank.pojos;

import java.util.ArrayList;

public class User {
	
	int id; 
	String firstname, lastname, password, username;
	ArrayList<Account> userAccounts;

	
	public User(){}


	public User(int id, String firstname, String lastname, String password, String username,
			ArrayList<Account> userAccounts) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
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


	public ArrayList<Account> getUserAccounts() {
		return userAccounts;
	}


	public void setUserAccounts(ArrayList<Account> userAccounts) {
		this.userAccounts = userAccounts;
	}
	
	
}
