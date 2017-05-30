package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {
	User addUser(String firstName, String lastName, String username, String password, String email);
	ArrayList<User> getAllUsers();
	User getUser(String username, String password);
	ArrayList<Account> getAllAccounts(int userId);
	int addAccount(int userId, int type);
	Account getAccountById(int id);
	boolean updateBalance(int id, double amount);
	boolean closeAccount(int id);
	ArrayList<User> getAccountUsers(int id);
	int getNumOfAccounts(String username);
	int getUserId(String username);
	boolean addAccountUser(int accountId, int userId);
}
