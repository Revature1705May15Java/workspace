package com.ex.test;

import java.util.ArrayList;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Customer;
import com.ex.pojos.Order;

public class Main {
	public static void main(String[] args) {
		
		DaoImpl dao = new DaoImpl();
//		
//		dao.addOrder(1000, 10000.00);
//		dao.addCustomer("test", "test", "VA", 1000, "test");
		
//		Customer temp = dao.getCustomerById(1000);
//		System.out.println(temp.toString());
//		
//		ArrayList<Customer> temp = dao.getCustomers();
//		System.out.println(temp.toString());
//		dao.createOrder(temp, 8888.88);
		
//		ArrayList<Order> temp = dao.getOrders();
//		System.out.println(temp.toString());
//		
		Customer c = dao.updateCustomer(1015, "test3", "test3", "VA", 1000, "test3");
		System.out.println(c.toString());
		
	//	ArrayList<Order> list = dao.getOrdersByCustomer(temp);
	//	System.out.println(list.toString());
	}
}
