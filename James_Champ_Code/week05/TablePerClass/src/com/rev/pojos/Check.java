package com.rev.pojos;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("check")
public class Check extends Payment {
	
	@Column(name="checkType")
	private String checkType;

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
}
