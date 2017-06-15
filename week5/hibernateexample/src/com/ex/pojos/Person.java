package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person {
	
	@Id
	@Column(name="P_ID")
	@SequenceGenerator(name="PID_SEQ", sequenceName="PERSONID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PID_SEQ")
	private int id;
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", fn=" + fn + ", ln=" + ln + "]";
	}
	@Column(name="FIRST_NAME")
	private String fn;
	
	@Column(name="LAST_NAME")
	private String ln;
	
	public Person(){}
	
	public Person(int id, String fn, String ln){ // to be used by hibernate deletePersonById
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
	}
		
	public Person(String fn, String ln) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
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
	
	
}