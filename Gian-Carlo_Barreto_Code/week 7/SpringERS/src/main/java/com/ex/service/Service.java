package com.ex.service;

import com.ex.beans.Employee;
import com.ex.beans.Request;
import com.ex.dao.DaoImpl;

public class Service {
	private DaoImpl dao;
	
	public Service() {
		this.dao = new DaoImpl();
	}
	
	public Employee auth(Employee e) {
		return this.dao.getEmployee(e.getEmail(), e.getPassword());
	}
	
	public boolean createEmployee(Employee e) {
		return this.dao.createEmployee(e);
	}
	
	public boolean createRequest(Request r) {
		return this.dao.createRequest(r);
	}
}
