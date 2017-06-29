package com.revature.Service;

import com.revature.DAO.DAO;
import com.revature.POJO.User;

public class Service {
	
	DAO dao = new DAO();
	
	public User newUser(User u){
		
		String username = u.getUsername();
		String password = u.getPassword();
		String fn = u.getFirstname();
		String ln = u.getLastname();
		String email = u.getEmail();
		
		
		User user = dao.createUser(username, password, fn, ln, email);
		
		System.out.println(user.toString());
		return user;
		
		
		
		
		
	}

}
