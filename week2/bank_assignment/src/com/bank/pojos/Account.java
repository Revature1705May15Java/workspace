package com.bank.pojos;

import java.sql.Date;
import java.util.ArrayList;

public class Account {
	int id;
	double balance;
	String type;
	Date dateOpened, dateClosed;
	ArrayList<User> accountHolders;
	
	public Account(){}
	
	public Account(int id, double balance, String type, Date dateOpened, Date dateClosed,
			ArrayList<User> accountHolders) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
		this.accountHolders = accountHolders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}

	public ArrayList<User> getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(ArrayList<User> accountHolders) {
		this.accountHolders = accountHolders;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", type=" + type + ", dateOpened=" + dateOpened
				+ ", dateClosed=" + dateClosed + ", accountHolders=" + accountHolders + "]";
	}
	
	
}
