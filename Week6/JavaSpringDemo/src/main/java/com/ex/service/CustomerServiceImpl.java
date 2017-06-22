package com.ex.service;

import java.util.List;

import com.ex.model.Customer;
import com.ex.repository.CustomerRepository;
import com.ex.repository.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;

	public CustomerServiceImpl(){}
	//create Constructor for constructor injection
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	//creating setter for setter injection
	// referenced by "name" in property xml
	public void setCustomerRepository(CustomerRepository cr) {
		this.customerRepository = cr;
	}
	

	/* (non-Javadoc)
	 * @see com.ex.service.CustomerService#findAll()
	 */
	public List<Customer> findAll(){
		System.out.println("in service layer!");
		return customerRepository.findAll();
	}
	
	
	
	

}
