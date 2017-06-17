package com.rev.pojos;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("creditCard")
public class CreditCard extends Payment {
	
	@Column(name="creditCardType")
	private String creditCardType;

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
}
