package com.bank.pojos;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.logs.Logger;

public class User {
	Logger Log = new Logger();
	int id;
	
	int numAccounts;
	
	String fn,ln,pw,uname;
	ArrayList <Account> userAccounts;
	public User() {
		super();
	}
	public User(int id, String fn, String ln, String uname, String pw, ArrayList<Account> userAccounts) {
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
	
	
	public int getNumAccounts() {
		return numAccounts;
	}
	public void setNumAccounts(int numAccounts) {
		this.numAccounts = numAccounts;
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