package com.ex.pojos;

import java.io.File;

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
	@SequenceGenerator(name="PERSONID_SEQ", sequenceName="PERSONID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PERSONID_SEQ")
	private int id;
	
	@Column(name="FIRST_NAME")
	String fn;
	
	@Column(name="LAST_NAME")
	String ln;
	
	@Column(name="BIO")
	String bio;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="FILE_UPLOADED")
	File piture;

	public Person(){}
	
	public Person(int id, String fn, String ln, String bio, String email, File piture) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.bio = bio;
		this.email = email;
		this.piture = piture;
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public File getPiture() {
		return piture;
	}

	public void setPiture(File piture) {
		this.piture = piture;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fn=" + fn + ", ln=" + ln + ", bio=" + bio + ", email=" + email + ", piture="
				+ piture + "]";
	}

}
