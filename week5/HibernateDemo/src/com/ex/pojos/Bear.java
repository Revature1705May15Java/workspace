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
@Table(name="Bear")
public class Bear {
	
	@Id
	@Column(name="B_ID")
	@SequenceGenerator(name="BID_SEQ", sequenceName="BID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BID_SEQ")
	private int id;
	
	private String bearColor;
	
	private String breed;
	
	private double heihgt;
	
	private double weight;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="Bear_Home")
	private Cave dwelling;
	/*Fetching strategy (Lazy/Eager) is the strategy that Hibernate
	 * will use for retrieving associated objects if the
	 * app needs to navigate the association. Fetch strategies may be declared
	 * in the ORM metadata, or overridden by an HQL Criteria Query
	 * 
	 */
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HoneyPot_ID")
	private HoneyPot honeyPot;

	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="Parent_CUB",
				joinColumns =@JoinColumn(name="Parent_ID"),
				inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	private Set<Bear> bearCubs;

	
	public Bear(){
		this.bearCubs = new HashSet<Bear>();
	}
	
	public Bear(int id) {
		super();
		this.id = id;
	}

	public Bear(int id, String bearColor, String breed, double heihgt, double weight, Cave dwelling,
			HoneyPot honeyPot) {
		super();
		this.id = id;
		this.bearColor = bearColor;
		this.breed = breed;
		this.heihgt = heihgt;
		this.weight = weight;
		this.dwelling = dwelling;
		this.honeyPot = honeyPot;
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

	public double getHeihgt() {
		return heihgt;
	}

	public void setHeihgt(double heihgt) {
		this.heihgt = heihgt;
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

	@Override
	public String toString() {
		return "Bear [bearColor=" + bearColor + ", breed=" + breed + ", heihgt=" + heihgt + ", weight=" + weight
				+ ", dwelling=" + dwelling + ", honeyPot=" + honeyPot + ", bearCubs=" + bearCubs + ", id=" + id + "]";
	}
	
	
}