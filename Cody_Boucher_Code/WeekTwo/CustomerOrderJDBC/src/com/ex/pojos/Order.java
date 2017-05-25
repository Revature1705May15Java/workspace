package com.ex.pojos;

import java.sql.Date;

public class Order {
	int id;
	int customerId;
	double total;
	Date dateOrder;
	
	public Order() {
		
	}

	public Order(int id, int customerId, double total, Date dateOrder) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.total = total;
		this.dateOrder = dateOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer() {
		return customerId;
	}

	public void setCustomer(int customerId) {
		this.customerId = customerId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	@Override
	public String toString() {
		return "Order [id = " + id + ", customer id = " + customerId + ", total = " + total + ", dateOrder = " + dateOrder + "]";
	}
	
	

}
