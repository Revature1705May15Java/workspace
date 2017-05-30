package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojo.User;

public class Service {
	static DAO dao = new DaoImpl();
	
	public User add(String fn, String ln, String uname, String pw){
		User temp = new User();
		temp = dao.getUser(uname, pw);
		
		if(temp != null){
			//username exist, prompt to change username, or login
			//sysout hey is this you and show the first name and last name of the given user name
		}else{
			dao.addUser(fn, ln, uname, pw);
		}
		
		return dao.getUser(uname, pw);
	}

}
