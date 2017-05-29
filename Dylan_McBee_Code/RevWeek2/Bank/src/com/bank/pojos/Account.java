package com.bank.pojos;

import java.time.LocalDate;
import java.util.ArrayList;



public class Account {
	 int id;
	 double balance;
	 Type type;
	 LocalDate dateOpened, dateClosed;
	 ArrayList<User> account_holders;
	
	 public Account(){
		 
	 }
	 public Account(int id, double balance, Type type, LocalDate dateOpened, LocalDate dateClosed,
			ArrayList<User> account_holders) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
		this.account_holders = account_holders;
	}
	public Account(int id, double balance, Type type, LocalDate dateOpened, LocalDate dateClosed) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public LocalDate getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(LocalDate dateOpened) {
		this.dateOpened = dateOpened;
	}
	public LocalDate getDateClosed() {
		return dateClosed;
	}
	public void setDateClosed(LocalDate dateClosed) {
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
