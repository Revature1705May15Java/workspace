package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DaoImp;
import com.bank.pojos.User;

public class Service 
{
	
	static DAO dao = new DaoImp ();
	
	public User AddUser (String fn,String ln,String email, String pw)
	{
		User temp = new User();
		
		temp = dao.getUser(email);
		
		if(temp!=null)
		{
			//promt user to change user name or log in
		}
		else
		{
			dao.addUser(fn, ln, email, pw);
		}
		
		return null;
	}
}
