package com.ers.test;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class Test {

	public static void main(String[] args) {
		Service s = new Service();
        
        Employee e = s.getEmployee("test@test.com");
        //s.addUser("test", "test", "12423545", "12412");
        
        System.out.println(e);

	}

}