package com.ex.test;

import java.util.ArrayList;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Customer;
import com.ex.pojos.Order;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoImpl dao = new DaoImpl();
		
		//dao.addOrder(10000, 10500);
		//dao.addCustomer("Darrin", "McIntyre", "IL", 10000, "somerandom@email.com");

		
		
		//Customer cust = dao.getCustomerById(10000);
		//System.out.println(cust.toString());
		
		
		
		//ArrayList<Customer> customers = dao.getAllCustomers();
		//for(int i = 0; i < customers.size(); i++) System.out.println(customers.get(i).toString());
		
		
		
		//Customer temp = dao.getCustomerById(10020);
		//System.out.println(temp.toString());
		//dao.createOrder(temp, 51999);
		
		//ArrayList<Order> orders = dao.getAllOrdersByCustomer(10000);
		//for(int i = 0; i < orders.size(); i++) System.out.println(orders.get(i).toString());
		
		Customer c = dao.updateCustomerName("Lei", "Raion", 10020);
		System.out.println(c.toString());
		
	}

}
