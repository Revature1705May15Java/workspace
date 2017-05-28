package com.bank.service;

import com.bank.dao.Dao;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class Service {

	private static final int MAX_ACCOUNTS = 6;
	static Dao dao = new DaoImpl();

	public User addUser(String fName, String lName, String password, String email) {
		//TODO: ensure unique email
		User newUser = null;
		
		if (dao.addUser(fName, lName, password, email)) {
			newUser = dao.getUser(email);
		}
		
		return newUser;
	}
	
	public User login(String email, String password) {
		User possibleUser = dao.getUser(email);
		User result = null;
		
		if (possibleUser != null && possibleUser.getPassword().equals(password) && possibleUser.getEmail().equals(email)) {
			result = possibleUser;
		}
		
		return result;
	}

	public ArrayList<Account> getAccounts(User u) {
		return dao.getAccountsForUser(u);
	}

	public ArrayList<AccountType> getAccountTypes() {
		return dao.getAccountTypes();
	}

	public Account addAccount(User u, int typeId) {
		Account a = null;
	    int numAccounts = dao.getNumOfAccounts(u);

	    if (numAccounts < MAX_ACCOUNTS) {
			a = dao.addAccount(u, typeId);
		}

		return a;
	}

	public boolean updateUser(User u, String fName, String lName, String email, String password) {
		boolean result = false;

		User updatedUser = new User(
				u.getId(),
				fName,
				lName,
				password,
				email,
				u.getAccounts()
		);

	    if (dao.updateUser(updatedUser)) {
	        result = true;
	        u.setFirstName(fName);
	        u.setLastName(lName);
	        u.setEmail(email);
	        u.setPassword(password);
		}

		return result;
	}

	public Account deposit(Account a, double amt) {
	    Account aCopy = new Account(
	    		a.getId(),
				a.getBalance() + amt,
				a.getOpened(),
				null,
				a.getType()
		);

	    Account result = null;
	    if (dao.updateAccount(aCopy)) {
	    	result = aCopy;
	    	a.setBalance(result.getBalance());
		}

		return result;
	}

	public Account withdraw(Account a, double amt) {
		Account result = null;

		Account aCopy = new Account(
				a.getId(),
				a.getBalance() - amt,
				a.getOpened(),
				null,
				a.getType()
		);

		if (amt >= 0.01 && aCopy.getBalance() >= -0.001 && dao.updateAccount(aCopy)) {
			result = aCopy;
			a.setBalance(result.getBalance());
		}

		return result;
	}

	public Account transfer(Account a, int recipientAccountId, double amt) {
		Account result = null;

		Account aCopy = new Account(
				a.getId(),
				a.getBalance() - amt,
				a.getOpened(),
				null,
				a.getType()
		);

		if (aCopy.getBalance() >= 0 && dao.transferFunds(a.getId(), recipientAccountId, amt)) {
			result = aCopy;
			a.setBalance(result.getBalance());
		}

		return result;
	}

	public Account closeAccount(Account a) {
		Account result = null;

		Account aCopy = new Account(
				a.getId(),
				a.getBalance(),
				a.getOpened(),
				LocalDate.now(),
				a.getType()
		);

		if (aCopy.getBalance() == 0 && dao.updateAccount(aCopy)) {
			result = aCopy;
			a.setClosed(result.getClosed());
		}

		return result;
	}
}
