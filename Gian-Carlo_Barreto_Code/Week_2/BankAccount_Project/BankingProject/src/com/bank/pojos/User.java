package com.bank.pojos;

import java.util.ArrayList;

/**
 * This class contains Information about a User
 * @author Gian-Carlo
 * 
 */
public class User {
	private int id;
	private int numOfAccounts;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private ArrayList<Account> accounts;
	
	/**
	 * Creates an instance of a User with default values
	 */
	public User() {
		super();
		this.id = 0;
		this.numOfAccounts = 0;
		this.firstName = null;
		this.lastName = null;
		this.username = null;
		this.password = null;
		this.email = null;
		this.accounts = new ArrayList<Account>();
	}
	
	/**
	 * Creates an instance of a User with specific values
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 */
	public User(int id, String firstName, String lastName, String username, String password,
			String email) {
		super();
		this.id = id;
		this.numOfAccounts = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.accounts = new ArrayList<Account>();
	}
	
	/**
	 * Gets the user's id
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the user's id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the number of the accounts the user has
	 * @return number of accounts
	 */
	public int getNumOfAccounts() {
		return numOfAccounts;
	}
	
	/**
	 * Sets the number of accounts the user has
	 * @param numOfAccounts
	 */
	public void setNumOfAccounts(int numOfAccounts) {
		this.numOfAccounts = numOfAccounts;
	}
	
	/**
	 * Gets the user's first name
	 * @return user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the user's first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the user's last name
	 * @return user's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the user's last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the user's username
	 * @return user's username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the user's username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get's the user's password
	 * @return user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the user's password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get's the user's email
	 * @return user's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the user's email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Adds an account to the accounts list and increments
	 * numOfAccounts by 1.
	 * @param account
	 */
	public void addAccount(Account account) {
		this.accounts.add(account);
		this.numOfAccounts++;
	}
	
	/**
	 * Removes an account from the accounts list and decrements
	 * numOfAccounts by 1.
	 * @param account
	 * @return true if account was removed from the acccounts list, false otherwise
	 */
	public boolean removeAccount(Account account) {
		boolean removed = false;
		
		if (this.accounts.size() > 0 && account != null) {
			for (Account a : this.accounts) {
				if (a.getId() == account.getId()) {
					this.accounts.remove(a);
					this.numOfAccounts--;
					removed = true;
					break;
				}
			}
		}
		
		return removed;
	}
	
	/**
	 * Get all of the user's accounts
	 * @return user's accounts
	 */
	public ArrayList<Account> getAllAccounts() {
		return this.accounts;
	}
	
	/**
	 * @return a string representation of this User
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", numOfAccounts=" + numOfAccounts + ", firstName=" + firstName + ", lastName="
				+ lastName + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
