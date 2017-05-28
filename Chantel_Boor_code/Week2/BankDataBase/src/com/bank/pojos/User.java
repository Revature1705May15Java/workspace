package com.bank.pojos;

import java.util.ArrayList;

public class User 
{
	int id;
	String fn,ln,pw,email;
	ArrayList <Account> users_account;
	
	public User (){}
	
	public User(int id, String fn, String ln, String pw, String email, ArrayList<Account> users_account) 
	{
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.email = email;
		this.users_account = users_account;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Account> getUsers_account() {
		return users_account;
	}
	public void setUsers_account(ArrayList<Account> users_account) {
		this.users_account = users_account;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fn=" + fn + ", ln=" + ln + ", pw=" + pw + ", email=" + email + ", users_account="
				+ users_account + "]";
	}
	
	
}
