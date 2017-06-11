package com.ers.dao;

import com.ers.pojos.Employee;


public interface DAO {
	public Employee getEmployee(String username);
	public Employee getEmployee(int id);
	public Employee addEmployee(String username, String password, String firstName, String lastName, boolean isManager);
}
