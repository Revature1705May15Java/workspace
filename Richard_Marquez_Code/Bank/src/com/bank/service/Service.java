package com.bank.service;

import com.bank.dao.Dao;
import com.bank.dao.DaoImpl;
import com.bank.pojos.User;

public class Service {
	
	static Dao dao = new DaoImpl();
	
	public User addUser(String fName, String lName, String password, String email) {
		//TODO: ensure unique email
		User newUser = null;
		
		if (dao.addUser(fName, lName, password, email)) {
			newUser = dao.getUser(email);
		}
		
		return newUser;
	}
	
	public User login(String email, String password) {
		User possibleUser = dao.getUser(email);
		User result = null;
		
		if (possibleUser != null && possibleUser.getPassword().equals(password) && possibleUser.getEmail().equals(email)) {
			result = possibleUser;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Service s = new Service();
		
//		boolean result = dao.addUser("richard", "marquez", "password", "richard92m@me.com");
//		System.out.println(result);
//		User u = s.login("richard92m@me.com", "password");
		User u = dao.getUser(1);
		System.out.println(u);
		System.out.println(dao.getAccountsForUser(u));
	}
	
	
}
