package com.ex.service;

import java.util.List;

import com.ex.model.Customer;

public interface CustomerService {

	List<Customer> findAll();
	String getName();
}