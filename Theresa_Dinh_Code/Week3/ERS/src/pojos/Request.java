package pojos;

import java.sql.Timestamp;

public class Request 
{
	int statusId; 
	Timestamp requestDate; 
	Timestamp resolveDate; 
	double amount; 
	String purpose; 
	int requestId; 
	int requesterId; 
	int approverId;
	
		
	public Request() 
	{
		super();
	}


	public Request(int statusId, Timestamp requestDate, Timestamp resolveDate, 
			double amount, int requestId, int requesterId, int approverId) 
	{
		super();
		this.statusId = statusId;
		this.requestDate = requestDate;
		this.resolveDate = resolveDate;
		this.amount = amount;
		this.requestId = requestId;
		this.requesterId = requesterId;
		this.approverId = approverId;
	}



	public Request(int statusId, Timestamp requestDate, Timestamp resolveDate, 
			double amount, String purpose, int requestId, int requesterId, int approverId) 
	{
		super();
		this.statusId = statusId;
		this.requestDate = requestDate;
		this.resolveDate = resolveDate;
		this.amount = amount;
		this.purpose = purpose;
		this.requestId = requestId;
		this.requesterId = requesterId;
		this.approverId = approverId;
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public Timestamp getRequestDate() {
		return requestDate;
	}


	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}


	public Timestamp getResolveDate() {
		return resolveDate;
	}


	public void setResolveDate(Timestamp resolveDate) {
		this.resolveDate = resolveDate;
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


	public int getApproverId() {
		return approverId;
	}


	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	@Override
	public String toString() 
	{
		return "Request [statusId=" + statusId + ", requestDate=" + requestDate + ", resolveDate=" + resolveDate
				+ ", amount=" + amount + ", purpose=" + purpose + ", requestId=" + requestId + ", requesterId="
				+ requesterId + ", approverId=" + approverId + "]";
	} 
	
}
