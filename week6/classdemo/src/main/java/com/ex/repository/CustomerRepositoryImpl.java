package com.ex.repository;

import java.util.ArrayList;
import java.util.List;

import com.ex.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {
	/* (non-Javadoc)
	 * @see com.ex.repository.CustomerRepository#findAll()
	 */
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		for(int i=0;i<6;i++){
			Customer c = new Customer();
			c.setFirstname("Firstname"+(char)(i+1)+"name");
			c.setLastname("Lastname"+(char)(i+30)+"name");
			customers.add(c);
		}
		return customers;
	}
}
