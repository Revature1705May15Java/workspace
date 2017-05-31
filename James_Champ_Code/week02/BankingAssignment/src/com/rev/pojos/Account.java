package com.rev.pojos;

import java.sql.Date;
import java.util.ArrayList;

// TODO: Add comments
// TODO: Implement comparable for sorting
public class Account {	
	private int accountId;
	private AccountType type;
	private double balance;
	private Date openDate;
	private Date closeDate;
	
	private ArrayList<User> accountHolders;

	public Account() {
		accountHolders = new ArrayList<User>();
	}
	
	// Used when user creates new account
	public Account(AccountType type, User accountHolder) {
		this.type = type;
		
		accountHolders = new ArrayList<User>();
		accountHolders.add(accountHolder);
	}
	
	public Account(AccountType type, double balance, Date openDate) {
		this.type = type;
		this.balance = balance;
		this.openDate = openDate;
		
		accountHolders = new ArrayList<User>();
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

	public ArrayList<User> getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(ArrayList<User> accountHolders) {
		this.accountHolders = accountHolders;
	}

	public void addAccountHolder(User accountHolder) {
		accountHolders.add(accountHolder);
	}
	
	@Override
	public String toString() {
		// TODO: Test for proper formatting
		// TODO: Format double for currency
		String result = String.format("\t%9s%15s%18s%15s%n", "Type:", "Balance:", "Acct. Number:", "Date Opened:");
		result += String.format("\t%9s%15.2f%18d%15s%n", type.getName(), balance, accountId, openDate.toString());
		
		result += "\n\tAccount Holders: ";
		for(User u : accountHolders) {
			result += " " + u.getFirstName() + " " + u.getLastName() + ",";
		}
		
		return result.substring(0, result.length() - 1);
	}
	
	
}
