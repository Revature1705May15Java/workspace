package com.revature_wk1.designpatterns.factory;

abstract class Plan 
{
	protected double rate;
	abstract void getRate();
	
	public void calcBill(int units)
	{
		System.out.println(units * rate);
	}
}
