package com.ex.pojos;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Order {
	int id;
	Customer cust;
	double total;
	Date date;
	
	public Order(){}
	
	public Order(int id, Customer cust, double total, Date date) {
		super();
		this.id = id;
		this.cust = cust;
		this.total = total;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", cust=" + cust + ", total=" + total + ", date=" + date + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
