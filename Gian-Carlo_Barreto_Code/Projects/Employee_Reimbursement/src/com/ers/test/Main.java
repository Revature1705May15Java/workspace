package com.ers.test;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.StateType;
import com.ers.service.Service;

public class Main {

	public static void main(String[] args) {
		Service service = new Service();
		//System.out.println(service.confirmLogin("jdoe@gmail.com", "password"));
		//System.out.println(service.createRequest(1000, 500.75, "This reimbursemnt request is for relocation."));
		//ArrayList<Request> requests = service.getEmployeeRequests(1000);
		//requests.forEach(r -> System.out.println(r));
		//System.out.println(service.getEmployeeById(1000));
		//System.out.println(service.updateEmployee(1000, "John", "Brown", "jdoe@gmail.com"));
		//System.out.println(service.isEmailAvailable("jdoe93@gmail.com"));
		//ArrayList<Request> requests = service.getAllRequests();
//		ArrayList<Employee> emps = service.getAllEmployees();
//		emps.forEach(e -> System.out.println(e));
//		requests.forEach(r -> System.out.println(r));
		
//		Request r = requests.get(0);
//		r.setType(StateType.APPROVED);
//		r.setManagerId(1005);
//		r.setManagerNote("Your reimbursement has been approved");
//		System.out.println(service.closeRequest(r));
		
		ArrayList<Request> requests = service.getAllResolvedRequest();
		requests.forEach(r -> System.out.println(r));
	}

}
