package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;

public interface DAO {
	public Employee getEmployee(String email);
	public Employee getEmployee(int employeeid);
	public void addEmployee(String email,String pw,String fn, String ln, int ismanager);
	public void updateEmployee(String email,String pw, String fn, String ln, int empid);
	public Request getRequest(int requestid);
	public void addRequest(double amt,String purpose, int requesterid);
	public void updateRequest(int requesterid, int requestid, String note, boolean approve);
	public ArrayList<Request> getEmployeeRequests(int employeeid);
	public String[] getStateNames();
	public ArrayList<Request> getAllRequests();
	public ArrayList<Employee> getAllEmployees();
	public void updateRequests(int newstate,int[] requestids,String[] notes, int resolverid);
}