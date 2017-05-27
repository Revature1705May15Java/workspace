package com.rev.pojos;

import java.sql.Date;
import java.util.ArrayList;

// TODO: Add comments
public class Account {	
	private int accountId;
	private AccountType type;
	private double balance;
	private Date openDate;
	private Date closeDate;
	
	private ArrayList<User> accountHolders;

	public Account() {
		// create array list
	}
	
	public Account(AccountType type, double balance, Date openDate) {
		this.type = type;
		this.balance = balance;
		this.openDate = openDate;
		
		// create array list
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public ArrayList<User> getAccountHolderIds() {
		return accountHolders;
	}

	public void setAccountHolderIds(ArrayList<User> accountHolders) {
		this.accountHolders = accountHolders;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", type=" + type + ", balance=" + balance + ", openDate=" + openDate
				+ ", closeDate=" + closeDate + ", accountHolders=" + accountHolders + "]";
	}
	
	
}
