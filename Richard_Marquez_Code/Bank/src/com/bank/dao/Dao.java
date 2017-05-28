package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public interface Dao {
	boolean addUser(String fName, String lName, String password, String email);
	Account addAccount(User u, int typeId);
	boolean addUserToAccount(User u, Account a);

	boolean updateUser(User u);
	boolean updateAccount(Account a);

	User getUser(String email);
	User getUser(int id);

	boolean transferFunds(int fromId, int toId, double amt);

	Account getAccount(int id);
	int getNumOfAccounts(User u);

	ArrayList<Account> getAccountsForUser(User u);
	ArrayList<User> getUsersForAccount(Account a);

	ArrayList<AccountType> getAccountTypes();
}
