package com.ers.dao;

import java.util.ArrayList;

import com.ers.beans.Employee;
import com.ers.beans.Request;

public interface DAO {

	Employee getEmployee(String email);
	ArrayList<Employee> getAllEmployees();
	Request submitRequest(double amount, String purpose, int requestorId);
	Request getRequestById(int id);
	boolean updateEmployee(int id, String email, String fn, String ln);
	ArrayList<Request> getAllRequests();
	Employee getEmployeeById(int id);
	ArrayList<Request> getPendingRequests();
	boolean resolveRequest(int requestId, int stateId, int resolverId);
	ArrayList<Request> getEmployeeRequests(int empId);
	
	
}