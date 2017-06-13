package com.rev.p15;

public class DoMath implements Calculator {


	public int addition(int a, int b) 
	{
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) 
	{
		return a-b;
	}

	@Override
	public int muliply(int a, int b) 
	{
		return a*b;
	}

	@Override
	public int divide(int a, int b) 
	{
		return a/b;
	}

}
