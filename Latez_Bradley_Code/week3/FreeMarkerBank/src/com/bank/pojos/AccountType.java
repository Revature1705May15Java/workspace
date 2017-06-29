package com.bank.pojos;

public class AccountType {
	
	int id;
	String name;
	
	
	@Override
	public String toString() {
		return "AccountType [id=" + id + ", name=" + name + "]";
	}
	public AccountType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public AccountType() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}