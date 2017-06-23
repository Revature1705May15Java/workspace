package com.ex.model;

public class Customer {
  
  private int id;
  private String firstname, lastname;
  
  public Customer(int id, String firstname, String lastname) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
    this.id = id;
  }

  public Customer(String firstname, String lastname) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  

}
