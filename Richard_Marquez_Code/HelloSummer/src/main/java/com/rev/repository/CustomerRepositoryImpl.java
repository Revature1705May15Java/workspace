package com.rev.repository;

import com.rev.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("richard", "marquez"));
        customers.add(new Customer("asdf", "qwerty"));
        customers.add(new Customer("bob", "bobbison"));
        customers.add(new Customer("chick", "jackson"));

        return customers;
    }

    @Override
    public String getName() {
        return "a naaame";
    }

}
