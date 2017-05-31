package com.bank.dao;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface Dao {
	public int updateBalance(Account account, double newbal);
	public int addUser(String fn, String ln, String userName, String password);
	public User getUser(String userName);
	public User getUser(int id);
	public Account addAccount(int accType, int balance, int cust_id);
	public int closeAccount(Account acc);
	public void makeDeposit(Account acc, int addBalace);
	public void makeWithdrawal(Account acc, int reduceBalance);
	public boolean editAcc(String edits, User u);
	public void joinAcc(Account acc, User u);
	public int transferMoney(Account acc, int accNum, int balance);
	
}
