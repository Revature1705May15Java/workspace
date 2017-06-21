package com.ex.service;

import java.util.List;

import com.ex.model.Customer;
import com.ex.model.repository.CustomerRepository;
//aka the DAO layer
public class CustomerServiceImpl implements CustomerService {
//Setter injection:
	private CustomerRepository customerRepository;

	//must write constructor for constructor injection
	public CustomerServiceImpl(){}
	public CustomerServiceImpl(CustomerRepository cr){
		this.customerRepository = cr;
	}
	
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	
	
//without spring:	
	//	private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();
//	
//	public List<Customer> findAll(){
//		return customerRepository.findAll();
//	}

}
