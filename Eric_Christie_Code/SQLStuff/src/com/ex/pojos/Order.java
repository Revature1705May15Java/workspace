package com.ex.pojos;

import java.sql.Date;

public class Order {
  int id;
  Date dateOrdered;
  double total;
  Customer customer;

  public Order() {
    super();
  }

  public Order(int id, Date dateOrdered, double total, Customer customer) {
    super();
    this.id = id;
    this.dateOrdered = dateOrdered;
    this.total = total;
    this.customer = customer;
  }

  public Order(Date dateOrdered, double total, Customer customer) {
    super();
    this.dateOrdered = dateOrdered;
    this.total = total;
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", dateOrdered=" + dateOrdered + ", total=" + total + ", customer=" + customer + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDateOrdered() {
    return dateOrdered;
  }

  public void setDateOrdered(Date dateOrdered) {
    this.dateOrdered = dateOrdered;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

}
