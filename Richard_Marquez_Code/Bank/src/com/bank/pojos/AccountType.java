package com.bank.pojos;

public class AccountType {
	int id;
	String name;
	
	public AccountType() {}
	
	public AccountType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		// return capitalized type name
		return (name.charAt(0)+"").toUpperCase() + name.substring(1);
	}
}
