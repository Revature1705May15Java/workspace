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
	@Id//SETS PRIMARY KEY
	@Column(name="H_ID")
	@SequenceGenerator(name="HPID_SEQ", sequenceName="HPID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="HPID_SEQ")
	private int id;
	
	@Column
	private double amount;
	
	
	
	
	public HoneyPot(int id, double honeyAmount) {
		super();
		this.id = id;
		this.amount = honeyAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getHoneyAmount() {
		return amount;
	}
	public void setAmount(double honeyAmount) {
		this.amount = honeyAmount;
	}
	@Override
	public String toString() {
		return "HoneyPot [id=" + id + ", Amount=" + amount + "]";
	}
	
	
	
	
	

}