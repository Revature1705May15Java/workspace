package com.rev.patterns;

public abstract class Plan {
	protected double rate;
	abstract void getRate();
	
	public double calculateBill(int units) {
		getRate();
		return units * rate;
	}
}
