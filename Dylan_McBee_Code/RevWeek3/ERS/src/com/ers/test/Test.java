package com.ers.test;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class Test {

	public static void main(String[] args) {
		Service s = new Service();
        
        Employee e = s.getEmployee("teste@test.com");
        //s.addUser("test", "test", "12423545", "12412");
        ArrayList<Employee> emps = s.getAllEmployees();
        System.out.println(emps);

	}

}
