package com.ex.test;

import java.util.List;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Customer;
import com.ex.pojos.Order;

public class Main {

	public static void main(String[] args) {
		
		DaoImpl dao = new DaoImpl();
		
		//dao.addOrder(1005, 10001.00);
		//dao.addCustomer("D", "M", "IN", 590.15, "email@email.com");
		
		//Customer temp = dao.getCustomerById(1015);
		//System.out.println(temp.toString());
		
		//dao.createOrder(temp, 876.55);
		//List<Customer> tempCustomers = dao.getAllCustomers();
		//tempCustomers.forEach(c->System.out.println(c));
		
		//List<Order> tempOrders = dao.getAllOrders();
		//tempOrders.forEach(o->System.out.println(o));
		
		//dao.updateCustomer(1000, "Meme", "McGee", "VA", 1005.00, "dank@email.com");
		
		Customer tempCustomer = dao.getCustomerById(1015);
		List<Order> ordersByCustomer = dao.getAllOrdersByCustomer(tempCustomer);
		ordersByCustomer.forEach(o->System.out.println(o));
	}

}