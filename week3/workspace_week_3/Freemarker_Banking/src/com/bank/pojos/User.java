package com.bank.pojos;

import java.util.ArrayList;

public class User {
	int id;
	String fn, ln, username, password;
	ArrayList<Account> accounts;
	
	public User(){}
	
	public User(int id, String fn, String ln, String username, String password, ArrayList<Account> accounts) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.username = username;
		this.password = password;
		this.accounts = accounts;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
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
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fn=" + fn + ", ln=" + ln + ", username=" + username + ", password=" + password
				+ ", accounts=" + accounts + "]";
	}
	
	
}
