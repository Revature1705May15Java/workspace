package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Worker;

public class EmployeeDaoImpl implements Dao {
	
	static List<Employee> employeeList;
	
	static{ 
		employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "John","Programmer"));
		employeeList.add(new Employee(2, "Tom","MySpacing"));
		employeeList.add(new Employee(3, "Jerry","Showing Me the Money"));
	}
	public Worker findById(int id) {
		for(Employee e : employeeList){
			if(e.getId() == id){
				return e;
			}
		}
		return null;
	}

	
	
}
