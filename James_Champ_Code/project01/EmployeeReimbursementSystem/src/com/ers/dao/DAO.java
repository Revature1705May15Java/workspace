package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;

public interface DAO {
	public Employee getEmployee(String email);
	public Employee addEmployee(Employee employee);
	public ArrayList<Employee> getAllEmployees();
	public Request addRequest(Request request);
}
