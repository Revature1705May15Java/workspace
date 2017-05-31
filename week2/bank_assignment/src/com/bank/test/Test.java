package com.bank.test;

import com.bank.dao.Impldao;
import com.bank.pojos.User;

public class Test {
	public static void main(String[] args) {
		Impldao dao = new Impldao();
		
		//dao.addUser("Lei", "Raion", "LeiRaion", "password");
		//User temp = dao.getUser("LeiRaion");
		//User temp = dao.getUser("");
		User temp = dao.getUser(100);
		System.out.println(temp.toString());
	}
}
