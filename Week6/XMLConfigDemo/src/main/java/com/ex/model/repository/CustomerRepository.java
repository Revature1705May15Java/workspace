package com.ex.model.repository;

import java.util.List;

import com.ex.model.Customer;
// when we reference the implemented customer repository, 
// we can now do it through the interface
public interface CustomerRepository {

	List<Customer> findAll();

}