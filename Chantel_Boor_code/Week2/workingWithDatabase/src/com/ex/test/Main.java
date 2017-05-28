package com.ex.test;

import java.util.ArrayList;

import com.ex.DaoImpl.DecImpl;
import com.ex.pojo.Customer;
import com.ex.pojo.Order;;

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		DecImpl d = new DecImpl();
		
		//d.addOrder(1, 1000);
		
		//Customer temp = d.getCustomerById(1);
		
		//d.addCustomer("James", "Bank", "CA", 2500.50, "jb@yahoo.com");
	
	Customer up = d.getCustomerById(16);	
	up.setLn("Smith");	
	
	d.updateCustomer(up);
	
	ArrayList<Customer>cl = d.getAllCustomers();

	for(Customer c:cl)
		System.out.println(c);
		
	

	/*
	d.createOrder(c, 99.95);	
	
	ArrayList<Order> ol = d.getAllOrders();
	
	for(Order o:ol)
		System.out.println(o);
	
	System.out.println();
	
	ArrayList<Order> olByC = d.getOrdersByC(c);
	
	for(Order o:olByC)
		System.out.println(o);
		*/
	}

}
