package com.corejava;

import java.util.Scanner;

public class Q17 {
/*
Write a program that calculates the simple interest 
on the principal, rate of interest and number of years 
provided by the user. Enter principal, rate and time 
through the console using the Scanner class.
Interest = Principal* Rate* Time

 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the interest rate: ");
		double interest=scan.nextDouble();
		System.out.println("Enter the number of years: ");
		int time = scan.nextInt();
		System.out.println("Enter the principal: ");
		int principal=scan.nextInt();
		System.out.println("The simple interest is: "+(interest*time*principal));
	}

}
