package com.rev.q17;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("This program will calulate the simple interest on a principal, rate, and time that you provide.\n");
		
		System.out.print("Please enter your principal as an integer: ");
		int p = scan.nextInt();
		System.out.println("\n");
		
		System.out.print("Please enter the rate as a double (3% would be 0.03): ");
		double r = scan.nextDouble();
		System.out.println("\n");
		
		System.out.print("Please enter the number of pay periods as an integer: ");
		int t = scan.nextInt();
		System.out.println("\n");
		
		System.out.printf("Your simple interest is: %.2f", (p * r * t));
		scan.close();
	}
}
