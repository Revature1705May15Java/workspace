package com.hw.q17;

import java.util.Scanner;

/**
 * Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the Scanner class.
		Interest = Principal* Rate* Time
 * @author Gian-Carlo
 *
 */
public class Interest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter principal, rate, and time separated by spaces: ");
		double principal = in.nextDouble();
		double rate = in.nextDouble();
		int time = in.nextInt();
		double interest = principal * rate * time;
		System.out.println(interest);
	}
}
