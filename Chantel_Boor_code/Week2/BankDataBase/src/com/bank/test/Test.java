package com.bank.test;

import com.bank.dao.DAO;
import com.bank.dao.DaoImp;
import com.bank.pojos.User;

public class Test 
{
	
	public static void main(String[] args)
	{
		
		
		
		DAO dao = new DaoImp ();
		
		dao.addUser("test", "test", "test", "test");
		
		dao.addUser("Chantel", "Boor", "cb", "pass");
		
		User test = dao.getUser("cb");
	}

}
