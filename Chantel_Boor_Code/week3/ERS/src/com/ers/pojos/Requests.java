package com.ers.pojos;

import java.sql.Date;

public class Requests 
{
	
	int requestId, reqester, resolver;
	RequestType tyep;
	Double amount;
	String purpose,note;
	Date requested,resolved;
	
	public Requests()
	{
		
	}

	public Requests(int requestId, int reqester, int resolver, RequestType tyep, Double amount, String purpose,
			String note, Date requested, Date resolved) {
		super();
		this.requestId = requestId;
		this.reqester = reqester;
		this.resolver = resolver;
		this.tyep = tyep;
		this.amount = amount;
		this.purpose = purpose;
		this.note = note;
		this.requested = requested;
		this.resolved = resolved;
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

	public int getResolver() 
	{
		return resolver;
	}

	public void setResolver(int resolver) 
	{
		this.resolver = resolver;
	}

	public RequestType getTyep()
	{
		return tyep;
	}

	public void setTyep(RequestType tyep) 
	{
		this.tyep = tyep;
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

	public String getNote()
	{
		return note;
	}

	public void setNote(String note) 
	{
		this.note = note;
	}

	public Date getRequested() 
	{
		return requested;
	}

	public void setRequested(Date requested) 
	{
		this.requested = requested;
	}

	public Date getResolved()
	{
		return resolved;
	}

	public void setResolved(Date resolved) 
	{
		this.resolved = resolved;
	}

	@Override
	public String toString() 
	{
		return "Requests [requestId=" + requestId + ", reqester=" + reqester + ", resolver=" + resolver + ", tyep="
				+ tyep + ", amount=" + amount + ", purpose=" + purpose + ", note=" + note + ", requested=" + requested
				+ ", resolved=" + resolved + "]";
	}
	
	

}
