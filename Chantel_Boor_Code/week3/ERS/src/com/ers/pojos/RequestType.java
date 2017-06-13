package com.ers.pojos;

public class RequestType 
{
	int typeId;
	String name;
	
	public RequestType()
	{
		
	}

	public RequestType(int typeId, String name) {
		super();
		this.typeId = typeId;
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RequestType [typeId=" + typeId + ", name=" + name + "]";
	}
	
	
}
