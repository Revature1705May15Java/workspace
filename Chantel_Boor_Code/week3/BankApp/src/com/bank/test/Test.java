package com.bank.test;

import com.bank.pojos.User;
import com.bank.service.Service;

public class Test {

	public static void main(String[] args) 
	{
		
		Service s = new Service();
		User u = s.loginUser("test", "test");
		
		System.out.println(u);

	}

}
