package com.bank.dao;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {

	public int updateBalance(Account account ,double newBal);
	public int addUser(String fn, String ln ,String uName, String pw);
	public User getUser(String uName);
	public User getUser(int id);
}
