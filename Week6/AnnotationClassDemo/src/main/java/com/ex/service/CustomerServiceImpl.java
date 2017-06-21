package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Customer;
import com.ex.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired //member variable injection
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
