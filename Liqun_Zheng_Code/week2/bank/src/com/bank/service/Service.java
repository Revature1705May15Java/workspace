package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {
	static DAO dao = new DaoImpl();
	final int AccountLimit = 3;
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
	public Account addAccount(User user, int typeId){
		Service s = new Service();
		Account temp = null;
		if(s.CheckUserLimit(user)){
		temp = dao.addAccount(user, typeId);
		}
		return temp;
		
	}
	
	public boolean CheckUserLimit(User user){
		if(dao.coutAccByUserId(user.getId()) < AccountLimit){
			return true;
		}
		else return false;
	}
}
