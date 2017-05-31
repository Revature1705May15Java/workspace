package com.revature.MAIN;

import com.revature.POJO.User;
import com.revature.Service.Service;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Service s = new Service();
		//public User(String username, String password, String firstname, String lastname, String email) {
		
		User user = new User("test", "432123", "tester", "user", "user@gmail.com");
		s.newUser(user);

	}

}
