package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Customer;
import com.ex.repo.CustomerRepo;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
//	private CustomerRepo cr = new CustomerRepoImpl();
	
	@Autowired //member variable injection
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
