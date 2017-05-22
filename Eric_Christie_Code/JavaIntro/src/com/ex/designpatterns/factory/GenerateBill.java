package com.ex.designpatterns.factory;

import java.util.Scanner;

public class GenerateBill {

	public static void main(String[] args) {
		
		Factory pf = new Factory();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the plan you want to generate a bill for.");
		String planType = in.nextLine();
		System.out.println("How many units for the bill will be calculated?");
		int units = in.nextInt();
		
		Plan plan = pf.getPlan(planType);
		System.out.println("The bill for " + planType + " of " + units + " units is " + plan);
		plan.getRate();
	}

}
