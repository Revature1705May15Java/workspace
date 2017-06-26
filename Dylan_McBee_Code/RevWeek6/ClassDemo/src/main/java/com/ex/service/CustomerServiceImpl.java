package com.ex.service;

import java.util.List;

import com.ex.model.Customer;
import com.ex.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(){
		
	}
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}



	public void setCustomerRepository(CustomerRepository cr) {
		this.customerRepository = cr;
	}

	// private CustomerRepository cr = new CustomerRepositoryImpl();
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ex.respository.CustomerService#findAll()
	 */
	public List<Customer> findAll() {
		System.out.println("In service layer!");
		return customerRepository.findAll();
	}

}
