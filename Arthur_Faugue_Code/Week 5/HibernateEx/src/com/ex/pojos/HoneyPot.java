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
	@SequenceGenerator(name="HONEYPOTID_SEQ", sequenceName="HONEYPOTID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="HONEYPOTID_SEQ")
	private int id;
	
	@Column
	private double amount;
	
	public HoneyPot(){}

	public HoneyPot(int id) {
		super();
		this.id = id;
	}

	public HoneyPot(int id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setHoneyAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "HoneyPot [id=" + id + ", amount=" + amount + "]";
	}
	
}
