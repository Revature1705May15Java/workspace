package com.ex.FactoryPattern;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GenerateBill {

	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		Factory factory = new Factory();
		Scanner in = new Scanner(System.in);
	
		System.out.println("Please enter the plan which you want a bill to be generated. ");
		String plan = in.nextLine();
		int units = 0;
		
		units = getUnits(in, units);
		
		Plan p = factory.getPlan(plan);
		
		System.out.print("The bill for " + plan + " of " + units + " units is: $");
		if(p!=null) {
			p.getrate();
			p.calculateBill(units);
		} else System.out.println("INVALID PLAN: Please try again.");
		
		System.out.println("\n\nWould you like to see another plan?");
		String test = in.nextLine().substring(0, 1).toLowerCase();
		if(test.equals("t") || test.equals("y")) run();
		
		System.out.println("\n   |-------------------|" + 
						   "\n   | Have a great day! |" + 
						   "\n   |-------------------|");
	}
	
	public static int getUnits(Scanner in, int units) {
		System.out.println("How many units for the bill will be calculated?");
		try{
			units = Integer.parseInt(in.nextLine());
			//break;
		} catch (NumberFormatException e) {
			System.out.println("Invalid entry, please enter a number.");
			units = getUnits(in, units);
		}
		return units;
	}

}
