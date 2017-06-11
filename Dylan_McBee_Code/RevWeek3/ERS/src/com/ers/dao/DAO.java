package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;

public interface DAO {

	public Employee getEmployee(String email);
	public ArrayList<Employee> getAllEmployees();
}
