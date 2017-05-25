package com.rev.Tester;

import com.rev.dao.DaoImpl;
import com.rev.pojos.Customer;

public class Main {
	public static void main(String[] args) {
		DaoImpl dao = new DaoImpl();
		//dao.addOrder(5, 42.63);
		//dao.addCustomer("Eric", "Clapton", "GB", 9999, "god2@heaven.inc");
		//System.out.println(dao.getCustomerById(20));
		
		//dao.createOrder(custs.get(0), 78.99);
		
//		ArrayList<Customer> custs = dao.getAllCustomers();
//		for (Customer c : custs) {
//			System.out.println(c);
//		}
		
//		ArrayList<Order> paulsOrders = dao.getAllOrdersForCustomer(dao.getCustomerById(10));
//		for (Order o : paulsOrders) {
//			System.out.println(o);
//		}
		
//		ArrayList<Order> allOrders = dao.getAllOrders();
//		for (Order o : allOrders) {
//			System.out.println(o);
//		}
		
		Customer eric = dao.getCustomerById(20);
		eric.setCredit(300.12);
		dao.updateCustomer(eric);
		
		
	}
}
