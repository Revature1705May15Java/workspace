package com.rev.pojos;

import java.sql.Date;

public class Order {
	int id;
	Date dateOrdered;
	Customer cust;
	double orderTotal;
	
	public Order() {
		// no-args constructor
	}
	
	public Order(int id, Date dateOrdered, Customer cust, double orderTotal) {
		super();
		this.id = id;
		this.dateOrdered = dateOrdered;
		this.cust = cust;
		this.orderTotal = orderTotal;
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

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", dateOrdered=" + dateOrdered + ", custid=" + cust.getlName() + ", orderTotal=" + orderTotal
				+ "]";
	}

	
	
}
