package com.ex.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEAR")
public class Bear {
	
	@Id
	@Column(name="B_ID")
	@SequenceGenerator(name="BID_SEQ",sequenceName="BID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BID_SEQ")
	private int id;
	
	@Column(name="COLOR")
	private String bearColor;
	
	@Column(name="BREED")
	private String breed;
	
	@Column(name="HEIGHT")
	private double height;
	
	@Column(name="WEIGHT")
	private double weight;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="BEAR_HOME")
	private Cave dwelling;
	/*
	 * A fetching strategy (LAZY or EAGER) is the strategy that Hibernate
	 * will use for retreiving associated objects if the app needs
	 * to navigate the association. Fetch strategies may be declared in the
	 * ORM metadata, or overridden by an HQL or 
	 * Criteria query
	 */
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HONEYPOT_ID")
	private HoneyPot honeyPot;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PARENT_CUB",
			joinColumns=@JoinColumn(name="PARENT_ID"),
			inverseJoinColumns=@JoinColumn(name="CUB_ID")
				)
	private Set<Bear> bearCubs;
	
	public Bear() {
		this.bearCubs=new HashSet<Bear>();
	}
	public Bear(int id, String bearColor, String breed, double height, double weight, Cave dwelling, HoneyPot honeyPot,
			Set<Bear> bearCubs) {
		super();
		this.id = id;
		this.bearColor = bearColor;
		this.breed = breed;
		this.height = height;
		this.weight = weight;
		this.dwelling = dwelling;
		this.honeyPot = honeyPot;
		this.bearCubs = bearCubs;
	}
	public Bear(String bearColor, String breed, double height, double weight, Cave dwelling, HoneyPot honeyPot,
			Set<Bear> bearCubs) {
		super();
		this.bearColor = bearColor;
		this.breed = breed;
		this.height = height;
		this.weight = weight;
		this.dwelling = dwelling;
		this.honeyPot = honeyPot;
		this.bearCubs = bearCubs;
	}
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBearColor() {
		return bearColor;
	}
	public void setBearColor(String bearColor) {
		this.bearColor = bearColor;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Cave getDwelling() {
		return dwelling;
	}
	public void setDwelling(Cave dwelling) {
		this.dwelling = dwelling;
	}
	public HoneyPot getHoneyPot() {
		return honeyPot;
	}
	public void setHoneyPot(HoneyPot honeyPot) {
		this.honeyPot = honeyPot;
	}
	public Set<Bear> getBearCubs() {
		return bearCubs;
	}
	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}
	
	
	
	
	
}
