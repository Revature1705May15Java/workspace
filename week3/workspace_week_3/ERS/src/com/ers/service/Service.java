package com.ers.service;

import com.ers.dao.Dao;
import com.ers.dao.ImplDao;
import com.ers.pojo.User;

public class Service {
	static Dao dao = new ImplDao();
	
	public User getUserInfo(String username) {
		User temp = new User();
		
		temp = dao.getUser(username);
		
		return temp;
	}
	
	public int addUser(String uname, String pw, String fn, String ln, int rank){
		return dao.addUser(uname, pw, fn, ln, rank);
	}
	
	public int addRequest(double amt, String purpose, int id){
		return dao.addRequest(amt, purpose, id);
	}
	
	public boolean editUser(User u){
		User temp = dao.getUser(u.getId());
		
		System.out.println("\n\nIN EDIT USER!! \n\n");
		
		if(!temp.getUsername().equals(u.getUsername())){
			System.out.println("uname");
			dao.editUser("USERNAME", u.getUsername(), u);
		}
		if(!temp.getPassword().equals(u.getPassword())){
			System.out.println("pw");
			dao.editUser("PASSWORD", u.getPassword(), u);
		}
		
		if(!temp.getFn().equals(u.getFn())){
			System.out.println("fn");
			dao.editUser("FIRSTNAME", u.getFn(), u);
		}
		if(!temp.getLn().equals(u.getLn())){
			System.out.println("ln");
			dao.editUser("LASTNAME", u.getLn(), u);
		}
		
		
		
		return true;
	}
}
