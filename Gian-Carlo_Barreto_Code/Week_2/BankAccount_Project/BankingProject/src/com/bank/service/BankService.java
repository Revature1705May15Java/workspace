package com.bank.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class BankService {
	private DAO dao;
	
	/**
	 * Creates an instance of this class
	 */
	public BankService() {
		this.dao = new DaoImpl();
	}
	
	/**
	 * Calls the addUser method of the DaoImpl class to add a user into the Bank_User table
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @return the User that was added
	 */
	public User createNewUser(String firstName, String lastName, String username, String password, String email) {
		return dao.addUser(firstName, lastName, username, password, email);
	}
	
	/**
	 * Checks to see if a username has not been used
	 * @param username
	 * @return true if the username is available, false otherwise
	 */
	public boolean isUsernameAvailable(String username) {
		ArrayList<User> users = dao.getAllUsers();
		boolean available = true;
		for (User u : users) {
			if (username.equals(u.getUsername())) {
				available = false;
				break;
			}
		}
		return available;
	}
	
	/**
	 * Checks to see if an email has not been used
	 * @param email
	 * @return true if the emailis available, false otherwise
	 */
	public boolean isEmailAvailable(String email) {
		ArrayList<User> users = dao.getAllUsers();
		boolean available = true;
		for (User u : users) {
			if (email.equals(u.getEmail())) {
				available = false;
				break;
			}
		}
		return available;
	}
	
	/**
	 * Confirms the user's login information
	 * @param username
	 * @param password
	 * @return The user's information
	 */
	public User confirmLogin(String username, String password) {
		return this.dao.getUser(username, password);
	}
	
	/**
	 * Creates an account for the user
	 * @param id
	 * @param type
	 * @return an account
	 */
	public Account createAccount(int id, int type) {
		int accountId = this.dao.addAccount(id, type);
		if (accountId != -1) {
			return this.dao.getAccountById(accountId);
		}
		else
			return null;
	}
	
	/**
	 * Gets all of the User's accounts
	 * @param userId
	 * @return list of accounts
	 */
	public ArrayList<Account> getAllAccounts(int userId) {
		return this.dao.getAllAccounts(userId);
	}
	
	/**
	 * Withdraws an amount from the account
	 * @param a
	 * @param amount
	 * @return true if withdraw was successful, false otherwise
	 */
	public boolean withdraw(Account a, double amount) {
		if (this.dao.updateBalance(a.getId(), (a.getBalance() - amount))) {
			a.setBalance(a.getBalance() - amount);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Deposits an amount from the account
	 * @param a
	 * @param amount
	 * @return true if deposit was successful, false otherwise
	 */
	public boolean deposit(Account a, double amount) {
		if (this.dao.updateBalance(a.getId(), (a.getBalance() + amount))) {
			a.setBalance(a.getBalance() + amount);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Closes an Account by setting the account's closeDate to the current date
	 * @param a
	 * @return true if account was closed, false otherwise
	 */
	public boolean closeAccount(Account a) {
		if (this.dao.closeAccount(a.getId())) {
			a.setCloseDate(LocalDate.now());
			return true;
		}
		return false;	
	}
	
	/**
	 * Get the account's users
	 * @param id
	 * @return list of users
	 */
	public ArrayList<User> getAccountUsers(int id) {
		return this.dao.getAccountUsers(id);
	}
	
	/**
	 * Get the number of accounts a user has
	 * @param username
	 * @return number of accounts
	 */
	public int getNumOfAccounts(String username) {
		return this.dao.getNumOfAccounts(username);
	}
	
	/**
	 * Add a user to an account
	 * @param accountId
	 * @param username
	 * @return true if user added, false otherwise
	 */
	public boolean addUser(int accountId, String username) {
		int userId = this.dao.getUserId(username);
		if (userId != -1) {
			if (this.dao.addAccountUser(accountId, userId)) {
				return true;
			}
			else 
				return false;
		}
		return false;
	}
}
