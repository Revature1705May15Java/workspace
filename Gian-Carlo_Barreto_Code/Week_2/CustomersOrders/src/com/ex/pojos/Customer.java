package com.ex.pojos;

public class Customer {
	int id;
	String firstName, lastName, address1, address2, city, state, postalCode, phone1, phone2, email;
	double credit;
	
	public Customer() {
		this.firstName = null;
		this.lastName = null;
		this.address1 = null;
		this.address2 = null;
		this.city = null;
		this.state = null;
		this.postalCode = null;
		this.phone1 = null;
		this.phone2 = null;
		this.email = null;
		this.credit = 0;
	}
	
	public Customer(String firstName, String lastName, String address1, String address2, String city,
			String state, String postalCode, String phone1, String phone2, String email, double credit) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.credit = credit;
	}
	
	public Customer(int id, String firstName, String lastName, String address1, String address2, String city,
			String state, String postalCode, String phone1, String phone2, String email, double credit) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.phone1 = phone1;
		this.phone2 = phone2;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
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
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", email=" + email + ", credit=" + credit + "]";
	}
}
