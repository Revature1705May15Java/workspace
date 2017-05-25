package com.rev.test;

import java.util.ArrayList;

import com.rev.dao.DAOImpl;
import com.rev.pojos.Customer;
import com.rev.pojos.Order;

public class Main {
	public static void main(String[] args) {
		DAOImpl dao = new DAOImpl();
		Customer c = dao.getCustomerById(1);
		c.setFirstName("NewName");
		dao.updateCustomer(c);
	}
}
