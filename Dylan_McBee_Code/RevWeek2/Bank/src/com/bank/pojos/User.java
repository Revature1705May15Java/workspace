package com.bank.pojos;

import java.util.ArrayList;

public class User {

	int id; 
	String fn, ln, pw, uName;
	ArrayList<Account> userAccounts;
	public User(){
		
	}
	public User(int id, String fn, String ln, String pw, String uName, ArrayList<Account> userAccounts) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.uName = uName;
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
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public ArrayList<Account> getUserAccounts() {
		return this.userAccounts;
	}
	public void setUserAccounts(ArrayList<Account> userAccounts) {
		this.userAccounts = userAccounts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fn=" + fn + ", ln=" + ln + ", pw=" + pw + ", uName=" + uName + ", userAccounts="
				+ userAccounts + "]";
	}
	public boolean removeAccount(Account account) {
		boolean removed = false;
		
		if (userAccounts.size() > 0 && account != null) {
			for (Account a : userAccounts) {
				if (a.getId() == account.getId()) {
					userAccounts.remove(a);
					removed = true;
					break;
				}
			}
		}
		
		return removed;
	}
}
