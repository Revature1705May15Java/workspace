package com.ex.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.model.Customer;

@Repository
public class MyCustomerRepository implements CustomerRepository {
  
  
  
  /* (non-Javadoc)
   * @see com.ex.repository.CustomerRepository#findAll()
   */
  public List<Customer> findAll() {
    List<Customer> customers = new ArrayList<Customer>();
    for (int i = 0; i < 6; i++) {
      customers.add(new Customer("Person", "" + i));
    }
    return customers;
  }
}
