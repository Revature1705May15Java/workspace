package com.ers.service;


import java.util.ArrayList;

import com.ers.dao.DAO;
import com.ers.dao.DAOImpl;
import com.ers.pojos.Employee;

public class Service {

	static DAO dao = new DAOImpl();

	public Employee getEmployee(String email) {
		return dao.getEmployee(email);
	}

	public boolean checkEmail(String email) {
		boolean exists = true;
		Employee temp = new Employee();
		temp = dao.getEmployee(email);
		if (temp == null) {
			// if user name does not exist, return to front end
			exists = false;
		}
		return exists;

	}
	public boolean checkPassword(String email, String pw){
		boolean correct = true;
		Employee temp = new Employee();
		temp = dao.getEmployee(email);
		if(temp.getPassword()!=null && temp.getPassword().equals(pw)){
			
		}
		else{
			correct = false;
		}
		return correct;
	}
	public ArrayList<Employee> getAllEmployees(){
		return dao.getAllEmployees();
	}
	

}
