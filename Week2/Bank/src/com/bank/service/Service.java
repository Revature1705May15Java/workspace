package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.User;

public class Service {
	
	static DAO dao = new DaoImpl();
	
	public User addUser(String fn, String ln, String uname, String pw){
		User temp = new User();
		temp = dao.getUser(uname);
		if(temp!=null){
			//username exists, prompt user to change username, or login 
		}
		else{
			dao.addUser(fn, ln, uname, pw);
		}
		
		
		return dao.getUser(uname);
		
	}
}
