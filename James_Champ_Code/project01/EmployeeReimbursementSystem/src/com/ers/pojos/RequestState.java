package com.ers.pojos;

public class RequestState {
	private int requestId;
	private String name;
	
	public RequestState(int requestId, String name) {
		super();
		this.requestId = requestId;
		this.name = name;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
