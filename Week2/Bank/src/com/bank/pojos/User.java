package com.bank.pojos;

import java.util.ArrayList;

public class User {
	int id; 
	String fn, ln, pw, uname;
	ArrayList<Account> userAccounts;
	
	public User(){}
	
	public User(int id, String fn, String ln, String pw, String uname, ArrayList<Account> userAccounts) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.uname = uname;
		this.userAccounts = userAccounts;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public ArrayList<Account> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(ArrayList<Account> userAccounts) {
		this.userAccounts = userAccounts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fn=" + fn + ", ln=" + ln + ", pw=" + pw + ", uname=" + uname + ", userAccounts="
				+ userAccounts + "]";
	}
	
	
	
	

}
