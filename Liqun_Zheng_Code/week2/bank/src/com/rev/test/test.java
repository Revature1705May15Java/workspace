package com.rev.test;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.User;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DAO dao = new DaoImpl();
		//dao.addUser("test", "test", "test", "test");
		User temp = dao.getUser("fsdf");
		System.out.println(temp);

	}

}
