package com.ex.pojos;

public class Customer {
	int id;
	String fn, ln, state, email;
	double credit;
	
	public Customer(){}
	
	public Customer(String fn, String ln, String state, String email, double credit) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.state = state;
		this.email = email;
		this.credit = credit;
	}
	
	public Customer(int id, String fn, String ln, String state, String email, double credit) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.state = state;
		this.email = email;
		this.credit = credit;
	}
	
	
	
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fn=" + fn + ", ln=" + ln + ", state=" + state + ", email=" + email
				+ ", credit=" + credit + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
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
