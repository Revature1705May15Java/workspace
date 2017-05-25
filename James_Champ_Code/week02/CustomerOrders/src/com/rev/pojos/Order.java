package com.rev.pojos;

import java.sql.Date;

public class Order {
	private int orderId;
	private Customer customerId;
	private double total;
	private Date timestamp;
	
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public Customer getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId.getId() + ", total=" + total + ", timestamp="
				+ timestamp + "]";
	}
}
