package com.rev.service;

import com.rev.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    String getName();
}
