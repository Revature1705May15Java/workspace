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
		
		Customer c = new Customer();
		for(int i = 0; i <10; i++){
			c.setFirstname(getSaltString());
			c.setLastname(getSaltString());
			customers.add(c);
		}
		
		
		return customers;
	}
	
	private static String getSaltString(){
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return SALTCHARS.substring(3,9);
	}
	
}
