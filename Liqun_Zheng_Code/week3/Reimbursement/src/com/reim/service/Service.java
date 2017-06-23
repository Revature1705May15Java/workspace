package com.reim.service;

import java.util.ArrayList;


import com.reim.dao.Dao;
import com.reim.dao.DaoImpl;
import com.reim.pojos.Employee;
import com.reim.pojos.Request;
import com.reim.pojos.State_type;



public class Service {
	
	static Dao dao = new DaoImpl();
	final String approved = "Approved";
	final String denied = "Denied";
	final int isManager = 1;
	final int isEmployee = 0;
	
	//Sign in by username and password return employee 
	//with all requests of this employee
	public Employee Signin(String username, String password){
		Employee temp = dao.findEmpByUname(username);
		ArrayList<Request> reqs = new ArrayList<Request>();
		if(temp.getPw().equals(password)&& temp.getIs_manager()==isEmployee){
			reqs= dao.findReqByEmpId(temp.getEmployee_id());
			temp.setEmployee_request(reqs);
			return temp;
		}
		else if(temp.getPw().equals(password)&& temp.getIs_manager()==isManager){
			reqs=dao.getAllRequests();		
			temp.setEmployee_request(reqs);
			ArrayList<Employee> emps = dao.getAllEmployee(isEmployee);
			temp.setEmployees(emps);
			return temp;
		}
		else
			return null;
	}
	
	//Submit a new request by input requester object, purpose, and amount of that new request
	public Request SubmitReq(Employee e, String purpose, double amount ){
		Request r = dao.addRequest(e, purpose, amount);
		if (r.getRequest_id() != 0){
			return r;
		}
		return null;
	}
	
	//Update information of an employee by input employee object, 
	//first name, last name, username and password
	public Employee updateInfo(Employee emp, String fname, String lname, String username, String password){
		Employee temp = dao.findEmpByUname(username);
		Service s = new Service();
		if(temp.getUname() == null){
			dao.updateEmployee(emp.getEmployee_id(), fname, lname, username, password);
			return s.Signin(username, password);
		}
		return null;
	}
	
	public Employee addEmployee(Employee emp, String fname, String lname, String username, String password, String checkManager){
		if(emp.getIs_manager()==isManager){
			Employee temp = dao.findEmpByUname(username);
			Service s = new Service();
			if(temp.getUname() == null){
				if(checkManager.equals("manager")){
					dao.addEmployee(fname, lname, username, password, isManager);
				}
				else if(checkManager.equals("employee")){
					dao.addEmployee(fname, lname, username, password, isEmployee);
				}
				return s.Signin(username, password);
			}
		}
		return null;
	}
	
	
	//Get all requests by input employee object
	public ArrayList<Request> getAllRequests(Employee emp){
			if(emp.getIs_manager()==isManager){
				ArrayList<Request> reqs = dao.getAllRequests();
				return reqs;
			}
		return null;
	}
	
	//Approve request by input manager object to set resolver,
	//request id and note
	public Request approveReq(Employee emp, int r_id, String note){
		if( emp.getIs_manager()==isManager){
			State_type type = dao.findState(approved);
			Request r;
			r = new Request();
			r = dao.appDenReq(emp, r_id, type, note);
			return r;
		}
		return null;
	}
	
	//Deny request by input manager object to set resolver,
	//request id and note
	public Request denyReq(Employee emp, int r_id, String note){
		if( emp.getIs_manager()==isManager){
			State_type type = dao.findState(denied);
			Request r;
			r = new Request();
			r = dao.appDenReq(emp, r_id, type, note);
			return r;
		}
		return null;
	}
	
	//get all employee by input manager object to check if
	//that person is manager, then return all employees
	public ArrayList<Employee> getAllEmps(Employee emp){
		if(emp.getIs_manager() == isManager){
			ArrayList<Employee> emps = dao.getAllEmployee(isEmployee);
			return emps;
		}
		
		return null;
		
	}
	
}
