package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Component
@Entity
@Table(name = "REQUEST")
public class Request 
{
	@Column(name = "STATUSID")
	int statusId; 
	
	@Column(name = "REQUESTDATE")
	Timestamp requestDate; 
	
	@Column(name = "RESOLVEDATE")
	Timestamp resolveDate; 
	
	@Column(name = "AMOUNTREQUESTED")
	double amount; 
	
	@Column(name = "PURPOSE")
	String purpose; 
	
	@Id
	@SequenceGenerator(name = "REQUESTID_SEQ", sequenceName = "REQUESTID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REQUESTID_SEQ")
	int requestId; 
	
	@Column
	@ManyToOne
	int requesterId; 
	
	@Column
	@ManyToOne
	int approverId;
	
	public Request()
	{
	}

	public Request(int statusId, Timestamp requestDate, Timestamp resolveDate, double amount, String purpose,
			int requestId, int requesterId, int approverId) {
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
	
}
