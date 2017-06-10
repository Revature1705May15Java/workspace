package com.rev.designpatterns.factory;

import java.util.Scanner;

public class GeneralBill 
{
	public static void main(String[] args) 
	{
		
		Factory factory = new Factory ();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the plan you want ");
		String plan = in.nextLine();
		
		System.out.println("How many units for the bill will be calcuated? ");
		int units = in.nextInt();
		
		Plan p = factory.getPlan(plan);
		System.out.println("The bill for " + plan + "of" + units +"is ");	
		p.getrate();
		p.calculateBill(units);
		
		
	}
}
