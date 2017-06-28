package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public interface DAO {
	public int updateBalance(Account account, double newbal);
	public int addUser(String fn, String ln, String uname, String pw);
	public Account getAccount(int id);
	public User getUser(String uname);
	public User getUser(int id);
	boolean receiveGenericChange(String tabletochange,String vartochange,String newinfo,String uname);
	public ArrayList<Integer> findAccounts(int userid);
	public void newAccount(int accounttype, int userid);
	public ArrayList<AccountType> fetchAccountTypes();
	
	
}