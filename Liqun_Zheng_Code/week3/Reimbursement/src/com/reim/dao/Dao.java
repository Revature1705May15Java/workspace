package com.reim.dao;

import java.util.ArrayList;

import com.reim.pojos.Employee;
import com.reim.pojos.Request;
import com.reim.pojos.State_type;


public interface Dao {
	public ArrayList<Request> findReqByEmpId(int emp_id);
	public Employee findEmpByUname(String uname);
	public State_type findTypeById(int type_id);
	Request addRequest(Employee u, String purpose, double amount);
	Request getRequest(int requestId);
	
	
}
