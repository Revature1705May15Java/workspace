package com.rev.pojos;

public class Customer {
	int id;
	String fName, lName, state, email;
	double credit;
	
	public Customer() {
		// no-args constructor
	}

	public Customer(String fName, String lName, String state, String email, double credit) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.state = state;
		this.email = email;
		this.credit = credit;
	}
	
	public Customer(int id, String fName, String lName, String state, double credit, String email) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.state = state;
		this.email = email;
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fName=" + fName + ", lName=" + lName + ", state=" + state + ", email=" + email
				+ ", credit=" + credit + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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
	
}
