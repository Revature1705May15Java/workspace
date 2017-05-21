package com.revature_wk1.designpatterns.factory;

import java.util.Scanner;

public class GenerateBill {

	public static void main(String[] args) 
	{
		Scanner insert = new Scanner(System.in);
		Factory factory = new Factory();
		
		System.out.println("Enter a plan type and your bill will be generated.");
		String plan = insert.nextLine();
		
		System.out.println("Number of units to be billed: ");
		int units = insert.nextInt();
		
		Plan p = factory.getPlan(plan);
		
		System.out.println("Your bill: " + plan + " for with these many units is: " + units);
		p.getRate();
		p.calcBill(units);
	}

}
