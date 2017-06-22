package com.ex.repo;

import java.util.List;

import com.ex.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}