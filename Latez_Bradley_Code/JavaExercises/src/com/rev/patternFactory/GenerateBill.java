package com.rev.patternFactory;

import java.util.Scanner;

public class GenerateBill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Factory factory = new Factory();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the plan that you want..");
		String plan =in.nextLine();
		
		System.out.println("How many unites for the bill will be calculated");
		int units = in.nextInt();
		
		Plan p = factory.getPlan(planType);
		
		System.out.println("The bill for +"+plan+" of "+ units+" units is "+"");
		p.getRate();
		p.calculateBill(units);

	}

}
