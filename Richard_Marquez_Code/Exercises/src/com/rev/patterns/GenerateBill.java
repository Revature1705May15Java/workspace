package com.rev.patterns;

import java.util.Scanner;

public class GenerateBill {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter your plan type: ");
		String planType = scan.nextLine();
		
		System.out.print("How many units for the bill will be calculated? ");
		int unitCount = Integer.parseInt(scan.nextLine());
		
		PlanFactory pf = new PlanFactory();
		Plan p = pf.getPlan(planType);
		
		double bill = p.calculateBill(unitCount);
		System.out.println("The bill for " + planType + " of " + unitCount + " units is: " + bill);
	}
}
