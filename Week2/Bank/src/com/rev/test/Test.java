package com.rev.test;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DaoImpl dao = new DaoImpl();
		
	//	dao.addUser("test2", "test2", "test2", "test2");
		
//	User temp = dao.getUser("");


		System.out.println(dao.getAccounts(105));
	
		

	}

}