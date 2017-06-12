package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.RequestState;

public interface DAO {
	public Employee getEmployee(String email);
	public Employee getEmployee(int id);
	public Employee addEmployee(Employee employee);
	public ArrayList<Employee> getAllEmployees();
	public Request addRequest(Request request);
	public ArrayList<Request> getAllRequests(RequestState state);
	public ArrayList<Request> getRequests(Employee employee, boolean isResolved);
}
