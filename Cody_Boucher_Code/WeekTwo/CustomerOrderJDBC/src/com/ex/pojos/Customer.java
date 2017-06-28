  package com.ex.pojos;

public class Customer {
	int id;
	String firstName;
	String lastName;
	String state;
	String email;
	double credit;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String state, String email, double credit) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.email = email;
		this.credit = credit;
	}

	public Customer(int id, String firstName, String lastName, String state, String email, double credit) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.email = email;
		this.credit = credit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Customer [id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", state = " + state
				+ ", credit = " + credit + ", email = " + email + "]";
	}
	
	
}