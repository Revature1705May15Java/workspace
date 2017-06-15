package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HONEYPOT")
public class HoneyPot {
	
	@Id
	@Column(name="H_ID")
	@SequenceGenerator(name="HID_SEQ", sequenceName="HONEYPOTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="HID_SEQ")
	private int id;
	
	@Column       // With no name in the annotation it will default to the variable name.
	private double amount;

	public HoneyPot(int id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	
	public HoneyPot(double amount) {
		super();
		this.amount = amount;
	}
	
	public HoneyPot(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}