package com.bank.pojos;

import java.util.ArrayList;

public class User {
	int id;
	String firstName, lastName,pw, uName;
	ArrayList<Account> userAccounts;
	public User() {
	}
	public User(int id, String firstName, String lastName, String pw, String uName, ArrayList<Account> userAccounts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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
		return userAccounts;
	}
	public void setUserAccounts(ArrayList<Account> userAccounts) {
		this.userAccounts = userAccounts;
	}
//	public boolean removeAccount(Account account) {
//		boolean removed = false;
//		
//		if (userAccounts.size() > 0 && account != null) {
//			for (Account a : userAccounts) {
//				if (a.getId() == account.getId()) {
//					userAccounts.remove(a);
//					removed = true;
//					break;
//				}
//			}
//		}
//		
//		return removed;
//	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pw=" + pw + ", uName="
				+ uName + ", userAccounts=" + userAccounts + "]";
	}
}
