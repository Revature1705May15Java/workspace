package com.bank.dao;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {
	
	public int updateBalance(Account account, double newbal);
	public int addUser(String fn, String ln, String uname, String pw);
	public User getUser(String uname);
	public User getUser(int id);
	

}
