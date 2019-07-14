package com.rev.designpatterns.factory;

import java.util.Scanner;

public class GenerateBill {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the plan which you want a bill to be generated for ");
		String plan = in.nextLine();
		
		System.out.println("How many units for the bill will be calculated? ");
		int units = in.nextInt();
		
		Plan p = factory.getPlan(plan);
		
		System.out.println("The bll for " + plan + "of " + units + "units is ");
		p.getrate();
		p.calculateBill(units);
		in.close();
	}
}
