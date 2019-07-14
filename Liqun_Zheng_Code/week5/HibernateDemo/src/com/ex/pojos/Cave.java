package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAVE")
public class Cave {
	
	
	@Id
	@Column(name="C_ID")
	@SequenceGenerator(name="CAVEID_SEQ", sequenceName="CAVEID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CAVEID_SEQ")
	private int id;
	@Column(name="SQ_FT")
	private double squreFootage;
	@Column(name="RENT")
	private double rent;
	public Cave() {
		
	}
	public Cave(double squreFootage, double rent) {
		super();
		this.squreFootage = squreFootage;
		this.rent = rent;
	}
	public Cave(int id, double squreFootage, double rent) {
		super();
		this.id = id;
		this.squreFootage = squreFootage;
		this.rent = rent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSqureFootage() {
		return squreFootage;
	}
	public void setSqureFootage(double squreFootage) {
		this.squreFootage = squreFootage;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	@Override
	public String toString() {
		return "Cave [id=" + id + ", squreFootage=" + squreFootage + ", rent=" + rent + "]";
	}

	
}
