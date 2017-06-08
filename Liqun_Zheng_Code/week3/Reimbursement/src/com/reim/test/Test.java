package com.reim.test;

import com.reim.dao.Dao;
import com.reim.dao.DaoImpl;
import com.reim.pojos.Employee;
import com.reim.pojos.Request;
import com.reim.service.Service;

public class Test {
	public static void main(String[] args) {
		
		Dao dao = new DaoImpl();
		Service s = new Service();
		Employee e = s.Signin("test", "test");
//		System.out.println(e.toString());
		
		Request r = dao.addRequest(e, "moving", 1500);
		System.out.println(r.toString());
		
	}
}
