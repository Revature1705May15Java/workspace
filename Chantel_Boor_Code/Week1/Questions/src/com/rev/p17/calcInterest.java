package com.rev.p17;

import java.util.Scanner;

public class calcInterest 
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double amount;
		double rate;
		int years;
		double intrest;
		
		System.out.println("Enter the principle amount: ");
		amount = input.nextDouble();
		
		System.out.println("Enter the rate: ");
		rate = input.nextDouble();
		
		System.out.println("Enter the amount of time in years: ");
		years = input.nextInt();
		
		input.close();
		
		intrest = amount * rate * years;
		
		System.out.print("Intrest: $" + intrest);
	}
}
