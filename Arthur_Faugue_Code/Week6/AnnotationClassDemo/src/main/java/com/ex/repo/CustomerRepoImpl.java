package com.ex.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.model.Customer;

@Repository("customerRepo")
public class CustomerRepoImpl implements CustomerRepo {
	/* (non-Javadoc)
	 * @see com.ex.repo.CustomerRepo#findAll()
	 */
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer c = new Customer();
		c.setFirstname("K. Durant");
		c.setLastname("Man");
		customers.add(c);
		
		return customers;
	}
	
	public String getName(){
		return "Durant";
	}
}
