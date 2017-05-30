package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public interface DAO {
	//user functions
	public User addUser(String firstName, String lastName, String userName, String password);
	public User getUser(String userName);
	public User getUserById(int id);
	public User upDate(User user);
	public void addAccountUser(User u, Account a);
	//account functions
	public Account addAcount(User user, int typeId);
	public Account getAccount(int id);
	public Account upDateAccount(Account account);
	public void transfer(int sendingId, int recievingId, double transferAmount);
	public ArrayList<AccountType> getAccountType();
	public ArrayList<Account> getAllAccounts(User user);
}
