package com.ex.repo;

import java.util.List;

import com.ex.model.Customer;

public interface CustomerRepo {

	List<Customer> findAll();

}