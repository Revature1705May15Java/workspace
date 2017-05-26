package com.bank.pojos;

import java.sql.Date;
import java.util.ArrayList;

public class Account {
	int id;
	double balance;
	AccountType type;
	Date dateOpened, dateClosed;
	ArrayList<Integer> user_ids;
	
	public Account(){}

	public Account(int id, double balance, AccountType type, Date dateOpened, Date dateClosed,
			ArrayList<Integer> user_ids) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
		this.user_ids = user_ids;
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

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
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

	public ArrayList<Integer> getUser_ids() {
		return user_ids;
	}

	public void setUser_ids(ArrayList<Integer> user_ids) {
		this.user_ids = user_ids;
	}
	
	
}