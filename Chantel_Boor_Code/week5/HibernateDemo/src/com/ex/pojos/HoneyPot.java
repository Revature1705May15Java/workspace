package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="HOMEYPOT")
public class HoneyPot
{
	@Id
	@Column (name="H_ID")
	@SequenceGenerator(name="HONEYPOTID_SEQ",sequenceName="HONEYPOTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="HONEYPOTID_SEQ")
	private int id;
	
	@Column
	private double honeyAmount;
	
	public HoneyPot()
	{
		
	}

	public HoneyPot(int id, double honeyAmount) {
		super();
		this.id = id;
		this.honeyAmount = honeyAmount;
	}

	public HoneyPot(double honeyAmount) {
		super();
		this.honeyAmount = honeyAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getHoneyAmount() {
		return honeyAmount;
	}

	public void setHoneyAmount(double honeyAmount) {
		this.honeyAmount = honeyAmount;
	}

	@Override
	public String toString() {
		return "HoneyPot [id=" + id + ", honeyAmount=" + honeyAmount + "]";
	}
	
	

}
