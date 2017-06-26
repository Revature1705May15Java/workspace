package com.revature.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Employee;
import com.revature.dao.Dao;

public class Driver 
{
	public static void main(String[] args) 
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Dao dao = (Dao)ac.getBean("myDao");
		
		Employee e = new Employee("Chantel","Boor","cb@email.com","pass",0);
		
		dao.makeEmployee(e);
		ac.close();
	}
}
