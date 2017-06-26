package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Customer;
import com.ex.repository.CustomerRepository;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired // member variable injection
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
