package com.bank.pojos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class contains information about an account
 * @author Gian-Carlo
 *
 */
public class Account {
	private int id;
	private int numOfUsers;
	private double balance;
	private Type type;
	private LocalDate openDate;
	private LocalDate closeDate;
	private ArrayList<User> users;
	
	/**
	 * Creates an instance of Account with default values
	 */
	public Account() {
		super();
		this.id = 0;
		this.numOfUsers = 0;
		this.balance = 0;
		this.type = null;
		this.openDate = null;
		this.closeDate = null;
		this.users = new ArrayList<User>();
	}
	
	/**
	 * Creates an instance of Account with specific values
	 * @param id
	 * @param numUsers
	 * @param balance
	 * @param type
	 * @param openDate
	 * @param closeDate
	 */
	public Account(int id, double balance, Type type, LocalDate openDate) {
		super();
		this.id = id;
		this.numOfUsers = 0;
		this.balance = balance;
		this.type = type;
		this.openDate = openDate;
		this.closeDate = null;
		this.users = new ArrayList<User>();
	}
	
	/**
	 * Gets the account id
	 * @return account id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the account id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Get number of users for this account
	 * @return number of users
	 */
	public int getNumOfUsers() {
		return this.numOfUsers;
	}
	
	/**
	 * Set the number of users for this account
	 * @param numUsers
	 */
	public void setNumOfUsers(int numUsers) {
		this.numOfUsers = numUsers;
	}

	/**
	 * Gets the account balance
	 * @return account balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the account balance
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Gets the account type
	 * @return account type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the account type
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Gets the account's open date
	 * @return account's open date
	 */
	public LocalDate getOpenDate() {
		return openDate;
	}

	/**
	 * Sets the account's open date
	 * @param openDate
	 */
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	/**
	 * Gets the account's close date
	 * @return account's close date
	 */
	public LocalDate getCloseDate() {
		return closeDate;
	}

	/**
	 * Gets the account's close date
	 * @param closeDate
	 */
	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * Adds a user to the list of users and increment
	 * numOfUsers by 1.
	 * @param user
	 */
	public void addUser(User user) {
		this.users.add(user);
		this.numOfUsers++;
	}
	
	/**
	 * Remove a user from the list of users and decrement
	 * numOfUsers by 1.
	 * @param user
	 * @return true if user removed, false otherwise
	 */
	public boolean removeUser(User user) {
		boolean removed = false;
		
		if (this.users.size() > 0 && user != null) {
			for (User u : this.users) {
				if (u.getId() == user.getId()) {
					this.users.remove(u);
					this.numOfUsers--;
					removed = true;
					break;
				}
			}
		}
		
		return removed;
	}
	
	/**
	 * Get all of the account's users
	 * @return account's users
	 */
	public ArrayList<User> getAllUsers() {
		return this.users;
	}
	
	/**
	 * @return a string representation of this Account
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", type=" + type + ", openDate=" + openDate
				+ ", closeDate=" + closeDate + "]";
	}
	
	
}