package com.rev.p15;

public class main {

	public static void main(String[] args) 
	{
		DoMath dm = new DoMath();
		
		int a = 10;
		int b = 2;
		
		System.out.println("Addition: "+ a + "+" + b + " = "  + dm.addition(a, b));
		System.out.println("Subtraction: " + a + "-" + b + " = " + dm.subtraction(a, b));
		System.out.println("Multiplication: " + a + "*" + b + " = " + dm.muliply(a, b) );
		System.out.println("Division: " + a + "/" + b + " = " + dm.divide(a, b));


	}

}
