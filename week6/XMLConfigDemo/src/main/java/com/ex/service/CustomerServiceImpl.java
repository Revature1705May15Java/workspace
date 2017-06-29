package com.ex.service;

import java.util.List;

import com.ex.model.Customer;
import com.ex.repo.CustomerRepo;
import com.ex.repo.CustomerRepoImpl;
import com.ex.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepo cr;
	
	
	
	public CustomerServiceImpl(CustomerRepo cr) {
		super();
		this.cr = cr;
	}


	//private CustomerRepo cr = new CustomerRepoImpl();

	public CustomerServiceImpl(){}
	
	
	public void setCr(CustomerRepo cr) {
		this.cr = cr;
	}

	public List <Customer> findAll(){
		System.out.println("SERVICE LAYER HIT");
		return cr.findAll();
	}
	
	

}