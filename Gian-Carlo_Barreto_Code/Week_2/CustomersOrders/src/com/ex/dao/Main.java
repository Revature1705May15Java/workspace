package com.ex.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.ex.pojos.Customer;
import com.ex.pojos.Order;

public class Main {
	public static void main(String[] args) {
		DaoImpl dao = new DaoImpl();
		//dao.addOrder(1000, 2500);
		//dao.addCustomer("Jane", "Doe", "1 Circle Dr.", "2 Circle Dr.", "Reston", "VA", "12345", "(352) 145-9854", "(352) 657-8754", 500, "janedoe@gmail.com");
		//Customer temp = dao.getCustomerById(1000);
//		ArrayList<Customer> customers = dao.getCustomers();
//		customers.forEach(c -> System.out.println(c));
//		System.out.println();
//		
//		Customer c = dao.getCustomerById(1010);
//		dao.createOrder(c, 2222.33);
//		ArrayList<Order> orders = dao.getAllOrdersByCustomer(1010);
//		orders.forEach(o -> System.out.println(o));
		HashMap updateFields = new HashMap();
		updateFields.put("credit_limit", 15000.00);
		dao.updateCustomer(1000, updateFields);
	}
}
