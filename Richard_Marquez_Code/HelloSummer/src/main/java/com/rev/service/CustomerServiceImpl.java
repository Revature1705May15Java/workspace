package com.rev.service;

import com.rev.model.Customer;
import com.rev.repository.CustomerRepository;
import com.rev.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired // member variable injection
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public CustomerServiceImpl() {
        System.out.println("no-args constructor");
    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        System.out.println("in constructor");
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public String getName() {
        return customerRepository.getName();
    }
}
