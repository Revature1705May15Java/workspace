package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public interface DAO {
	
	public double updateBalance(int AccId, double newbal);
	public int addUser(String fn, String ln, String uname, String pw);
	public User getUser(String uname);
	public User getUser(int id);
	public Account addAccount(User u, int typeId);
	public Account getAccByAccId(int accId);
	public int recentCreated();
	public int recentCreatedUser();
	public void addUserAccount(int userId, int accountId);
	public AccountType getTypeName(int typeId);
	public ArrayList<Account> findAccByUserId(int UserId);
	public ArrayList<User> findUserByAccId(int accId);
	public int coutAccByUserId(int userId);
	boolean closeAccount(int accId);
	
	
}