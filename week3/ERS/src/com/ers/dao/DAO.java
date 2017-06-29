package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;

public interface DAO {
	
	
	public int addEmployee(String uname, String pw,String fn, String ln, int isManager);
	public Employee getEmployee(String uname);
	public Employee updateEmployee(String uname, String pw, String fn, String ln, int id);
	
	public int request(Double amount, String purpose, int requesterid);
	
	public ArrayList <Request> getRequestsById(int id);
	
	public int alterRequest(int Stateid, String note, int requestid,int managerid);
	public ArrayList <Employee> viewEmployees();
	public ArrayList <Request> viewAllRequests();
	
	
	
	
	public ArrayList <Request> viewOpenRequests();
	
	public ArrayList <Request> viewClosedRequestsById(int id);
	public ArrayList <Request> viewOpenRequestsById(int id);
	int request(int amount, String purpose, int requesterid);
	
	
	
	
	
	
	
	

}
	