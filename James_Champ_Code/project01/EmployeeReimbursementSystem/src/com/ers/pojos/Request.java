package com.ers.pojos;

import java.sql.Date;

public class Request {
	/**
	 * The ID number of this request.
	 */
	private int requestId;
	private RequestState state;
	private Date openDate;
	private Date closeDate;
	private double amount;
	private String purpose;
	private String note;
	private Employee requester;
	private Employee manager;
	
	public Request() {
		super();
	}
	
	public Request(double amount, String purpose, Employee requester) {
		this.amount = amount;
		this.purpose = purpose;
		this.requester = requester;
	}
	
	public Request(int requestId, RequestState state, Date openDate, Date closeDate, double amount, String purpose,
			String note, Employee requester, Employee manager) {
		super();
		this.requestId = requestId;
		this.state = state;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.amount = amount;
		this.purpose = purpose;
		this.note = note;
		this.requester = requester;
		this.manager = manager;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Employee getRequester() {
		return requester;
	}

	public void setRequester(Employee requester) {
		this.requester = requester;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}
}
