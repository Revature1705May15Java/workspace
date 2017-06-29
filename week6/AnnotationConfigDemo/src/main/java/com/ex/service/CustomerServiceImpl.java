package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Customer;
import com.ex.repo.CustomerRepo;


@Service ("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired //variable injection
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


	@Override
	public int getnum() {
		// TODO Auto-generated method stub
		return 7;
	}
	
	

}