package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.services.WorkerServices;

public class MainClass {
/*
 * Create the employee and service class together
 * Have them create the manager and manager service
 * 	
 */
	
	
	public static void main(String[] args) {
		MainClass app = new MainClass();
		
		ApplicationContext ac =  new ClassPathXmlApplicationContext("beans.xml");
		
		WorkerServices ws = (WorkerServices) ac.getBean("theDaoService");
		
		Employee e1 = (Employee) ws.findEmployee(1);
		Manager m1 = (Manager) ws.findManager(1);
		
		
		System.out.println(e1.getName() +" is an employee "+ m1.getName());
		
		((AbstractApplicationContext) ac).close();
	}
	
	


}
