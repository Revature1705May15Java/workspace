package com.revature.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//the entity annotation tells hibernate that we want this class made into a table
//by default it maps the class to a table of the same name

//The table annotation is an optional annotation that provides additional
//info about the table. For example this can be used to name the table something other than the class naem


//The two annotations required for table creation are the Entity annotation used 
//to map the table and the Id annotation used to mark teh primary key


@Entity
@Table(name = "REQUESTS")
public class Requests 
{
	
	//annotation for primary key
	@Id
	
	//optional tag that changes the name of the column to something other than varible name
	@Column (name="R_ID")
	
	//These two tags are used to automatically generate a number value that
	//will become a unique primay key
	@SequenceGenerator(name="RID_SEQ",sequenceName="RID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="RID_SEQ")
	int requestId;
	
	@Column(name="STATUS")
	String type;
	
	@Column(name="AMOUNT")
	Double amount;
	
	@Column(name="PURPOSE")
	String purpose;
	
	@Column(name="REQUESTOR")
	int reqester;
	
	@Column(name="REQUESTED")
	Date requested;
	
	
	
	public Requests()
	{
		
	}
	
	

	public Requests(int requestId, String type, Double amount, String purpose, int reqester, Date requested) {
		super();
		this.requestId = requestId;
		this.type = type;
		this.amount = amount;
		this.purpose = purpose;
		this.reqester = reqester;
		this.requested = requested;
	}



	public int getRequestId()
	{
		return requestId;
	}

	public void setRequestId(int requestId)
	{
		this.requestId = requestId;
	}

	public int getReqester()
	{
		return reqester;
	}

	public void setReqester(int reqester) 
	{
		this.reqester = reqester;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public Double getAmount() 
	{
		return amount;
	}

	public void setAmount(Double amount) 
	{
		this.amount = amount;
	}

	public String getPurpose() 
	{
		return purpose;
	}

	public void setPurpose(String purpose) 
	{
		this.purpose = purpose;
	}

	public Date getRequested() 
	{
		return requested;
	}

	public void setRequested(Date requested) 
	{
		this.requested = requested;
	}



	@Override
	public String toString() {
		return "Requests [requestId=" + requestId + ", type=" + type + ", amount=" + amount + ", purpose=" + purpose
				+ ", reqester=" + reqester + ", requested=" + requested + "]";
	}
	
	
	
	

}