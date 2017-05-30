package com.bank.pojos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
	int id;
	double balance;
	int type;
	LocalDate openDate;
	LocalDate closeDate;
	ArrayList<Integer> userIDs;
	
	public Account() {}

	public Account(int id, double balance, int type, LocalDate openDate, LocalDate closeDate, ArrayList<Integer> userIDs) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.userIDs = userIDs;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public LocalDate getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	public ArrayList<Integer> getAccountHolders() {
		return userIDs;
	}

	public void setAccountHolders(ArrayList<Integer> userIDs) {
		this.userIDs = userIDs;
	}

	@Override
	public String toString() {
		return "Account [id = " + id + ", balance = " + balance + ", type = " + type + ", openDate = " + openDate
				+ ", closeDate = " + closeDate + ", UserIDs = " + userIDs + "]";
	}
	
	
	
	
}
