package com.reim.service;

import java.util.ArrayList;


import com.reim.dao.Dao;
import com.reim.dao.DaoImpl;
import com.reim.pojos.Employee;
import com.reim.pojos.Request;



public class Service {
	
	static Dao dao = new DaoImpl();
	
	//Sign in by username and password return employee 
	//with all requests of this employee
	public Employee Signin(String username, String password){
		Employee temp = dao.findEmpByUname(username);
		ArrayList<Request> reqs = new ArrayList<Request>();
		if(temp.getPw().equals(password)){
			reqs= dao.findReqByEmpId(temp.getEmployee_id());
			temp.setEmployee_request(reqs);
			return temp;
		}
		else
			return null;
	}
	
	public Request SubmitReq(Employee e, String purpose, double amount ){
		Request r = dao.addRequest(e, purpose, amount);
		if (r.getRequest_id() != 0){
			return r;
		}
		return null;
	}
	
	public Employee updateInfo(Employee emp, String fname, String lname, String username, String password){
		Employee temp = dao.findEmpByUname(username);
		Service s = new Service();
		if(temp.getUname() == null){
			dao.updateEmployee(emp.getEmployee_id(), fname, lname, username, password);
			return s.Signin(username, password);
		}
		return null;
	}
}
