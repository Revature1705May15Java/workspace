package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;

/**
 * Defines the methods that will be used to manipulate the ERS database.
 * @author Gian-Carlo
 *
 */
public interface DAO {
	Employee getEmployee(String email, String password);
	Request addRequest(int empId, double amount, String purpose);
	ArrayList<Request> getEmployeeRequests(int empId);
	Employee getEmployeeById(int empId);
	boolean updateEmployee(int empId, String firstName, String lastName, String email);
	ArrayList<Employee> getAllEmployees();
	ArrayList<Request> getAllRequests();
	boolean closeRequest(int reqId, int state, int managerId, String mangerNote);
	ArrayList<Request> getPendingRequests();
	ArrayList<Request> getResolvedRequest();
}
