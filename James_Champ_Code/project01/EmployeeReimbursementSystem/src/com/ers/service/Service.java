package com.ers.service;

import com.ers.dao.DAO;
import com.ers.dao.DAOImpl;
import com.ers.exceptions.InvalidPasswordException;
import com.ers.exceptions.NoSuchEmployeeException;
import com.ers.pojos.Employee;

public class Service {
	DAO dao;
	
	public Service() {
		dao = new DAOImpl();
	}
	
	public Employee login(String email, String password) 
			throws NoSuchEmployeeException, InvalidPasswordException{
		Employee employee = dao.getEmployee(email);
		
		if(employee == null) {
			throw new NoSuchEmployeeException("No such employee exists.");
		}
		else if(!employee.getPassword().equals(password)) {
			throw new InvalidPasswordException("Invalid password");
		}
		
		return employee;
	}
}
