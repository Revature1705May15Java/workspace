package com.bank.test;

import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DaoImp;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Test 
{
	
	public static void main(String[] args)
	{
		
		
		
		DAO dao = new DaoImp ();
		
		//dao.addUser("test", "test", "test", "test");
		
	//	dao.addUser("Chantel", "Boor", "cb", "pass");
		
		User test = dao.getUser("cb");
		
	//	int i = dao.getAccountNumber(1);
		
		//dao.addAccount(test, 1);
		
		ArrayList <Account> a = dao.getAccount(test.getId());
		
		System.out.println(a.get(0));
		
	//	dao.getAccount(test.getId());
		
		//System.out.print(i);
		
		
	}

}
