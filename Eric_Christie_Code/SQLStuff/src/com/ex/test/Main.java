package com.ex.test;

import com.ex.dao.ImplementedDAO;

public class Main {

  public static void main(String[] args) {
    ImplementedDAO dao = new ImplementedDAO();
    // dao.addOrder(2, 50.00);
    // dao.addCustomer("person", "one", "GA", 2.0, "1@email.com");
//    Customer temp = dao.getCustomer(1);
//    System.out.println(temp);
    // System.out.println(dao.getAllCustomers());

    // dao.createOrder(temp, 24.95);

//    ArrayList<Order> orders = dao.getOrdersByCustomer(temp);
//    System.out.println(orders);
    System.out.println(dao.getCustomer(11));
    System.out.println(dao.updateCustomer(11, "customer", "eleven", "VA", "eleven@email.com", 11.0));
    System.out.println(dao.getCustomer(11));
    System.out.println(dao.updateCustomer(11, "john", "doe", "VA", "jd@email.com", 2.0));
    System.out.println(dao.getCustomer(11));
    System.out.println(dao.updateToNull(11, true, true, true));
    System.out.println(dao.getCustomer(11));
  }

}
