package com.ex.beans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REQUEST")
public class Request implements Serializable {
	
	// Setting up hibernate annotations
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reqSeq")
	@SequenceGenerator(allocationSize=1, name="reqSeq", sequenceName="REQ_SEQ")
	@Column(name="REQUEST_ID")
	private int requestId;
	
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@Column(name="OPEN_DATE")
	private LocalDate openDate;
	
	@Column(name="CLOSE_DATE")
	private LocalDate closedDate;
	
	public Request() {}
	
	public Request(int requestId, int employeeId, String state, double amount, LocalDate openDate,
			LocalDate closedDate) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.state = state;
		this.amount = amount;
		this.openDate = openDate;
		this.closedDate = closedDate;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}
	public LocalDate getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(LocalDate closedDate) {
		this.closedDate = closedDate;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", employeeId=" + employeeId + ", state=" + state + ", amount="
				+ amount + ", openDate=" + openDate + ", closedDate=" + closedDate + "]";
	}
}
