package com.bank.dao;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO 
{
	public int updateBalance (Account account,double amount);
	
	public int addUser(String fn, String ln, String email,String pass);
	
	public User getUser(String email);
	
	public User getUser (int id);

}
