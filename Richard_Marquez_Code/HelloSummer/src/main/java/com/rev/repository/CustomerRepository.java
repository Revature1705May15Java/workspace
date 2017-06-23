package com.rev.repository;

import com.rev.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    String getName();
}
