package com.ers.dao;

import com.ers.pojos.Employee;

public interface DAO {
	
	public Employee getEmployee(String username);
	public int addEmployee(String uname, String pw,String fn, String ln, int isManager);
	
	

}
