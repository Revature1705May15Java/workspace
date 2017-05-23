package com.rev.patterns.factory;

import java.util.Scanner;

public class GenerateBill {
	public static void main(String[] args) {
		PlanFactory fact = new PlanFactory();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your plan type: ");
		String plan = scan.nextLine();
		
		System.out.println("How many units for the bill will be calculated: ");
		int units = scan.nextInt();
		
		Plan p = fact.getPlan(plan);
		p.getRate();
		
		System.out.print("The bill for " + plan + " of " + units + " units is: ");
		p.calculateBill(units);
		System.out.println(p == null);
		System.out.println(p.getClass().getName());
		
		scan.close();
	}
}
