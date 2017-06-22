package com.ex.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.model.Customer;


@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository 
{
	/* (non-Javadoc)
	 * @see com.ex.repo.CustomerRepository#findAll()
	 */
	@Override
	public List <Customer> findAll ()
	{
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer c = new Customer();
		c.setFirstName("Billy");
		c.setLastName("Bob");
		
		customers.add(c);
		
		return customers;
		
	}
}
