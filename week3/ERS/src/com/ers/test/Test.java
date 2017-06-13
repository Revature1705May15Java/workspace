package com.ers.test;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

public class Test {
	static Service service = new Service();
	public Test() {
	}
	
	
	public static void main(String[] args) {
		Employee emp = Service.loginUser("markworth@gmail.com", "password");
		ArrayList<Request>reqs= Service.getRequests(emp);
		System.out.println(reqs.get(0).getName());
		
	}
}
