package com.ex.pojos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REIMBURSEMENT")
public class Reimbursement {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USeq")
	@SequenceGenerator(allocationSize=1,name="USeq", sequenceName="U_SEQ")
	@Column(name="U_ID")
	private int id;
	
	public Reimbursement(){}
	
	
	public Reimbursement(Timestamp dateCreated, Timestamp dateResolved, User creator, User resolver, String description,
			String status) {
		super();
		this.dateCreated = dateCreated;
		this.dateResolved = dateResolved;
		this.creator = creator;
		this.resolver = resolver;
		this.description = description;
		this.status = status;
	}

	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;
	
	@Column(name="AMOUNT")
	private double amount;
	
	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTimestampCreated() {
		return dateCreated;
	}

	public void setTimestampCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getTimestampResolved() {
		return dateResolved;
	}

	public void setTimestampResolved(Timestamp dateResolved) {
		this.dateResolved = dateResolved;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="DATE_RESOLVED")
	private Timestamp dateResolved;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="R_CREATOR")
	private User creator;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="R_RESOLVER")
	private User resolver;
	
	@Column(name="R_DESCRIPTION")
	private String description;
	
	@Column(name="R_STATUS")
	private String status;

}
