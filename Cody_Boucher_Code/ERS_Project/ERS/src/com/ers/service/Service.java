package com.ers.service;

import com.ers.dao.DAO;
import com.ers.dao.DaoImp;
import com.ers.pojos.Employee;

public class Service {
	static DAO dao = new DaoImp();
	
	public Employee login(String username, String password) {
		Employee emp = dao.getEmployee(username);
		String correctPassword = emp.getPassword();
		if(password.equals(correctPassword)) {
			System.out.println("correct password");
			return emp;
		}
		else {
			System.out.println("incorrect password");
			return null;
		}
	}
}
