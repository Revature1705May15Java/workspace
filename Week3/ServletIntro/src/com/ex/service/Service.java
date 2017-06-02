package com.ex.service;

import java.util.HashMap;

public class Service {
	static HashMap<String, String> users = new HashMap<String, String>();



	public HashMap<String,String>addUsers(String username, String password){
		users.put(username, password);
		return users;
	}

	public Boolean login(String username, String password){
		users.put("Genesis" , "password");
		users.put("test" , "test");
		users.put("test2", "value");

		if(!users.containsKey(username)){
			return null;
		}
		else{
			String pass = users.get(username);
			if(pass.equals(password)){
				return true;
			}
			else return false;
		}
	}

	public HashMap<String,String> getUsers(){
		return users;
	}


}
