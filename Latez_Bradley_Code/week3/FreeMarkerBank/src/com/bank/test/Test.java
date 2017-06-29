package com.bank.test;

import com.bank.pojos.User;
import com.bank.service.Service;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Service s = new Service();
		
		User i = s.getbyUserId(1);
		//s.addUser("test", "test", "12423545", "12412");
		
		System.out.println(i);

	}

}
