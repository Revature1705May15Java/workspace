package com.bank.pojos;

import java.sql.Date;
import java.util.ArrayList;



public class Account {
	 int id;
	 double balance;
	 AccountType type;
	 Date dateOpened, dateClosed;
	 ArrayList<User> account_holders;
	
	 public Account(){
		 
	 }
	 public Account(int id, double balance, AccountType type, Date dateOpened, Date dateClosed,
			ArrayList<User> account_holders) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
		this.account_holders = account_holders;
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
	public ArrayList<User> getAccount_holders() {
		return account_holders;
	}
	public void setAccount_holders(ArrayList<User> account_holders) {
		this.account_holders = account_holders;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", type=" + type + ", dateOpened=" + dateOpened
				+ ", dateClosed=" + dateClosed + ", account_holders=" + account_holders + "]";
	}
}
