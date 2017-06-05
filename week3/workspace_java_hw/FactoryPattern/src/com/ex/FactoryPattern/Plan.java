package com.ex.FactoryPattern;

import java.text.DecimalFormat;

public abstract class Plan {
	protected double rate;
	DecimalFormat decimals = new DecimalFormat("#.00");
	abstract void getrate();
	
	public void calculateBill(int units) {
		System.out.println(decimals.format(units*rate));
	}
}
