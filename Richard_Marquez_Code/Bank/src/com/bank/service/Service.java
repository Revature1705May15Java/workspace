package com.bank.service;

import com.bank.dao.Dao;
import com.bank.dao.DaoImpl;
import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.PasswordStorage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Service {

	private static final int MAX_ACCOUNTS = 6;
	private static Dao dao = new DaoImpl();

	public User addUser(String fName, String lName, String password, String email) {
		User newUser = null;

		try {
			String hashedPassword = PasswordStorage.createHash(password);
			if (dao.addUser(fName, lName, hashedPassword, email)) {
				newUser = dao.getUser(email);
			}
		} catch(Exception e) {
			Logger.log(e.getMessage());
		}

		return newUser;
	}

	public User login(String email, String password) {
		User possibleUser = dao.getUser(email);
		User result = null;

		try {
			boolean correctPassword = PasswordStorage.verifyPassword(password, possibleUser.getPassword());

			if (possibleUser != null && correctPassword && possibleUser.getEmail().equals(email)) {
				result = possibleUser;
			}
		} catch (Exception e) {
			Logger.log(e.getMessage());
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

	public User updateUser(User u, String fName, String lName, String email, String password) {
		User updatedUser = null;

		try {
			updatedUser = new User(
					u.getId(),
					fName,
					lName,
					PasswordStorage.createHash(password),
					email,
					u.getAccounts()
			);
		} catch (Exception e) {
			Logger.log(e.getMessage());
		}

		return dao.updateUser(updatedUser);
	}

	public Account deposit(Account a, double amt) {
		Account updatedAcct = null;

		if (amt >= 0.01) {
			updatedAcct = new Account(
					a.getId(),
					a.getBalance() + amt,
					a.getOpened(),
					null,
					a.getType(),
					a.getUsers()
			);
		}

		return dao.updateAccount(updatedAcct);
	}

	public Account withdraw(Account a, double amt) {
		Account result = null;

		Account updatedAcct = new Account(
				a.getId(),
				a.getBalance() - amt,
				a.getOpened(),
				null,
				a.getType()
		);

		if (amt >= 0.01 && updatedAcct.getBalance() >= -0.001) {
			result = dao.updateAccount(updatedAcct);
		}

		return result;
	}

	public Account transfer(Account a, int recipientAccountId, double amt) {
		Account result = null;

		Account updatedAcct = new Account(
				a.getId(),
				a.getBalance() - amt,
				a.getOpened(),
				null,
				a.getType()
		);

		if (amt >= 0.01 && updatedAcct.getBalance() >= 0.001 && dao.transferFunds(a.getId(), recipientAccountId, amt)) {
			result = updatedAcct;
		}

		return result;
	}

	public boolean closeAccount(Account a) {
		boolean result = false;

		Account updatedAcct = new Account(
				a.getId(),
				a.getBalance(),
				a.getOpened(),
				LocalDate.now(),
				a.getType()
		);

		if (updatedAcct.getBalance() == 0 && dao.updateAccount(updatedAcct) != null) {
			result = true;
			a.setClosed(updatedAcct.getClosed());
		}

		return result;
	}

	public boolean addJointAccountHolder(Account a, String email) {
		boolean result = false;
		User newHolder = dao.getUser(email);

		if (newHolder != null && !userIsAccountHolder(newHolder, a) && dao.getNumOfAccounts(newHolder) < MAX_ACCOUNTS) {
			result = dao.addUserToAccount(newHolder, a);
		}

		return result;
	}

	public boolean removeJointAccountHolder(Account a, String email) {
		boolean result = false;
		User holder = dao.getUser(email);

		if (holder != null && userIsAccountHolder(holder, a) && getNumAccountHolders(a) > 1) {
			result = dao.removeUserFromAccount(holder, a);
		}

		return result;
	}

	private int getNumAccountHolders(Account a) {
		Account mostRecentAcct = dao.getAccount(a.getId());
		return mostRecentAcct.getUsers().size();
	}

	private boolean userIsAccountHolder(User u, Account a) {
		boolean result = false;
		User mostRecentUser = dao.getUser(u.getId());

		for (int possibleAccountId : mostRecentUser.getAccounts()) {
			if (possibleAccountId == a.getId()) {
				result = true;
				break;
			}
		}

		return result;
	}
}
