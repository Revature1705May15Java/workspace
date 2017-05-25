package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface Dao {
	int updateBalance(Account acct, double newBal);
	boolean addUser(String fName, String lName, String password, String email);
	User getUser(String email);
	User getUser(int id);
	ArrayList<Account> getAccountsForUser(User u);
}
