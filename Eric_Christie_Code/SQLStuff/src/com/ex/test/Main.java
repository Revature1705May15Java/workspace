package com.ex.test;

import java.util.ArrayList;

import com.ex.dao.ImplementedDAO;
import com.ex.pojos.Customer;
import com.ex.pojos.Order;

public class Main {

	public static void main(String[] args) {
		ImplementedDAO dao = new ImplementedDAO();
		// dao.addOrder(2, 50.00);
		// dao.addCustomer("person", "one", "GA", 2.0, "1@email.com");
		Customer temp = dao.getCustomer(1);
		System.out.println(temp);
		// System.out.println(dao.getAllCustomers());

		// dao.createOrder(temp, 24.95);

		ArrayList<Order> orders = dao.getOrdersByCustomer(temp);
		System.out.println(orders);
	}

}
