package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.Account;
import com.rev.pojos.AccountType;
import com.rev.pojos.User;

public interface DAO {
	public int updateBalance(Account account, double newBalance);
	public int addUser(String firstName, String lastName, String password, String email);
	public User getUser(String email);
	public ArrayList<Account> getUserAccounts(User user);
	public ArrayList<User> getAccountUsers(Account account);
}

