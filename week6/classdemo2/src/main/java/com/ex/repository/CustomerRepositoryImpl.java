package com.ex.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.model.Customer;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {
	/* (non-Javadoc)
	 * @see com.ex.repository.CustomerRepository#findAll()
	 */
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		for(int i=0;i<6;i++){
			Customer c = new Customer();
			c.setFirstname("Firstname"+(i+1)+"name");
			c.setLastname("Lastname"+(i+30)+"name");
			customers.add(c);
		}
		return customers;
	}
	public String getName(){
		return "Mark";
	}
}
