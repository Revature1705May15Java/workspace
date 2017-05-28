package com.bank.pojos;

public class AccountType 
{
	int typeId;
	String Name;
	
	public AccountType() { }

	public AccountType(int typeId, String name) {
		super();
		this.typeId = typeId;
		Name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "AccountType [typeId=" + typeId + ", Name=" + Name + "]";
	}
	
	
	
	
}
