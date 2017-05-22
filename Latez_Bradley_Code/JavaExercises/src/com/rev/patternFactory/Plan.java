package com.rev.patternFactory;

public abstract class Plan {
	protected double rate;
	abstract void getRate();
	
	public void calculateBill(int units){
		System.out.println(units*rate);
	}

}
