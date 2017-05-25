package com.bank.pojos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
	int id;
	double balance;
	AccountType type;
	LocalDate opened;
	LocalDate closed;
	ArrayList<User> holders;
	
	public Account() {}
	
	public Account(int id, double balance, LocalDate opened, LocalDate closed, AccountType type,
			ArrayList<User> holders) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.opened = opened;
		this.closed = closed;
		this.holders = holders;
	}

	public Account(int id, double balance, LocalDate opened, LocalDate closed, AccountType type) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.opened = opened;
		this.closed = closed;
		this.holders = holders;
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

	public LocalDate getOpened() {
		return opened;
	}

	public void setOpened(LocalDate opened) {
		this.opened = opened;
	}

	public LocalDate getClosed() {
		return closed;
	}

	public void setClosed(LocalDate closed) {
		this.closed = closed;
	}

	public ArrayList<User> getHolders() {
		return holders;
	}

	public void setHolders(ArrayList<User> holders) {
		this.holders = holders;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", type=" + type + ", opened=" + opened + ", closed="
				+ closed + ", holders=" + holders + "]";
	}
	
}
