package com.bank.test;

import com.bank.pojos.User;
import com.bank.service.Service;


public class test {
	 
	public static void main(String[] args) {
		Service service = new Service();
		User u = new User();
		u = service.Signin("test", "test");
		System.out.println(u.toString());
	}
}
