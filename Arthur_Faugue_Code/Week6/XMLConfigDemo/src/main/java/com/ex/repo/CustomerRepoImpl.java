package com.ex.repo;

import java.util.ArrayList;
import java.util.List;

import com.ex.model.Customer;

public class CustomerRepoImpl implements CustomerRepo {
	/* (non-Javadoc)
	 * @see com.ex.repo.CustomerRepo#findAll()
	 */
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer c = new Customer();
		c.setFirstname("Guy");
		c.setLastname("Man");
		customers.add(c);
		
		return customers;
	}
}
