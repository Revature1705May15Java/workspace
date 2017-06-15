package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVE")
public class Cave {
	@Id
	@Column(name="C_ID")
	@SequenceGenerator(name="CID_SEQ", sequenceName="CAVEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CID_SEQ")
	private int id;
	
	@Column(name="SQ_FT")
	private double squareFootage;
	
	@Column(name="RENT")
	private double rent;
	
	public Cave(int id, double squareFootage, double rent) {
		super();
		this.id = id;
		this.squareFootage = squareFootage;
		this.rent = rent;
	}
	
	public Cave(double squareFootage, double rent) {
		super();
		this.squareFootage = squareFootage;
		this.rent = rent;
	}
	
	public Cave(){}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", squareFootage=" + squareFootage + ", rent=" + rent + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}
	
}
