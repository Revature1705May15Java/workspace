package com.ex.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.model.Customer;

@Repository("customerRepo")
public interface CustomerRepo {

	List<Customer> findAll();

}