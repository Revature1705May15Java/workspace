package com.ex.service;

import java.util.List;

import com.ex.model.Customer;
import com.ex.repo.CustomerRepo;
import com.ex.repo.CustomerRepoImpl;

public class CustomerServiceImpl implements CustomerService {
//	private CustomerRepo cr = new CustomerRepoImpl();
	private CustomerRepo CustomerRepo;
	
	public CustomerServiceImpl() {
		super();
	}
	public CustomerServiceImpl(com.ex.repo.CustomerRepo customerRepo) {
		super();
		CustomerRepo = customerRepo;
	}
	public void setCustomerRepo(CustomerRepo cr) {
		this.CustomerRepo = cr;
	}
	/* (non-Javadoc)
	 * @see com.ex.service.CustomerService#findAll()
	 */
	public List<Customer> findAll(){
		System.out.println("Service layer");
		return CustomerRepo.findAll();
	}
}
