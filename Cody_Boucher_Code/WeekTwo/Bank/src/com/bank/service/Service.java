package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.User;

public class Service {
	
	static DAO dao = new DaoImpl();

	public User addUser(String firstName, String lastName, String userName, String password) {
		User temp = new User();
		temp = dao.getUser(userName);
		if(temp != null) {
			//username exists, prompt user to change username or login
			System.out.println("Username must be unique!");
		}
		else {
			dao.addUser(firstName, lastName, userName, password);
		}
		return dao.getUser(userName);
		
	}
}
