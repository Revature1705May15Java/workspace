package com.hw.interest;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		double principal;
		double rate;
		double time;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter principal: ");
		principal = scan.nextDouble();
		System.out.print("Enter rate: ");
		rate = scan.nextDouble();
		System.out.print("Enter time (years): ");
		time = scan.nextDouble();
		double interest = principal * (rate/100) * time;
		System.out.println("The interest is: " + interest);
		scan.close();
	}
}
