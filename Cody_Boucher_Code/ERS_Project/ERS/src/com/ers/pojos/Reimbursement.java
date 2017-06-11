package com.ers.pojos;

import java.sql.Date;

public class Reimbursement {
	private int stateId;
	private Date dateRequested;
	private Date dateResolved;
	private double amount;
	private String purpose;
	private int requestId;
	private int requesterId;
	private int resolverId;
	private String notes;
	
	public Reimbursement() {
		
	}

	public Reimbursement(int stateId, Date dateRequested, Date dateResolved, double amount, String purpose, int requestId, int requesterId, int resolverId, String notes) {
		super();
		this.stateId = stateId;
		this.dateRequested = dateRequested;
		this.dateResolved = dateResolved;
		this.amount = amount;
		this.purpose = purpose;
		this.requestId = requestId;
		this.requesterId = requesterId;
		this.resolverId = resolverId;
		this.notes = notes;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public Date getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
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

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Reimbursement [stateId=" + stateId + ", dateRequested="
				+ dateRequested + ", dateResolved=" + dateResolved + ", amount="
				+ amount + ", purpose=" + purpose + ", requestId=" + requestId
				+ ", requesterId=" + requesterId + ", resolverId=" + resolverId
				+ ", notes=" + notes + "]";
	}
}
