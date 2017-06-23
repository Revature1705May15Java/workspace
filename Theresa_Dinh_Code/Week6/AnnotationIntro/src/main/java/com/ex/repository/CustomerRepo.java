package com.ex.repository;

import java.util.List;

import com.ex.model.Customer;

public interface CustomerRepo {

	List<Customer> findAll();
	public void timer(); 
}