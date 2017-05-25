package com.ex.test;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Customer;

public class Main {
	public static void main(String[] args) {
		DaoImpl dao = new DaoImpl();
		//dao.addOrder(1, 500);
		//dao.addCustomer("A", "A", "VA", 500, "AA");
		//Customer temp = dao.getCustomerById(5);
		//System.out.println(temp.toString());
		//dao.createOrder(temp, 875.75);
		//dao.getOrders();
		//dao.getCustomerOrders(1);
		//hard coded for now, was having issues commiting changes to database
		dao.updateCustomer("C", "C", "CA", 600, "CC", 44);

	}
}

//TODO get all orders

//get all orders by customer
//get all orders
//update customer 