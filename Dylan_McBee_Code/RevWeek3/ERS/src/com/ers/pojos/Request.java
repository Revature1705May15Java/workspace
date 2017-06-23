package com.ers.pojos;

import java.time.LocalDate;

public class Request {
	int requestId;
	StateType type;
	double amount;
	String purpose;
	LocalDate dateRequested;
	int requestorId;
	LocalDate dateResolved;
	int resolverId;
	String lastName;
	String eLastName;



public Request(){
	super();
}

public Request(int requestId, StateType type, double amount, String purpose, LocalDate dateRequested, int requestorId,
		LocalDate dateResolved, int resolverId) {
	super();
	this.requestId = requestId;
	this.type = type;
	this.amount = amount;
	this.purpose = purpose;
	this.dateRequested = dateRequested;
	this.requestorId = requestorId;
	this.dateResolved = dateResolved;
	this.resolverId = resolverId;
}

public int getRequestId() {
	return requestId;
}

public void setRequestId(int requestId) {
	this.requestId = requestId;
}

public StateType getType() {
	return type;
}

public void setType(StateType type) {
	this.type = type;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public String getPurpose() {
	return purpose;
}

public void setPurpose(String purpose) {
	this.purpose = purpose;
}

public LocalDate getDateRequested() {
	return dateRequested;
}

public void setDateRequested(LocalDate dateRequested) {
	this.dateRequested = dateRequested;
}

public int getRequestorId() {
	return requestorId;
}

public void setRequestorId(int requestorId) {
	this.requestorId = requestorId;
}

public LocalDate getDateResolved() {
	return dateResolved;
}

public void setDateResolved(LocalDate dateResolved) {
	this.dateResolved = dateResolved;
}

public int getResolverId() {
	return resolverId;
}

public void setResolverId(int resolverId) {
	this.resolverId = resolverId;
}
public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String geteLastName() {
	return eLastName;
}

public void seteLastName(String eLastName) {
	this.eLastName = eLastName;
}

@Override
public String toString() {
	return "Request [requestId=" + requestId + ", status=" + type + ", amount=" + amount + ", purpose=" + purpose
			+ ", dateRequested=" + dateRequested + ", requestorId=" + requestorId + ", dateResolved=" + dateResolved
			+ ", resolverId=" + resolverId + "]";
}
}
