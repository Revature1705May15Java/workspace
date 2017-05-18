package com.ex.exceptions;

import java.util.Scanner;

public class AssertionEx {

	/*
	 * Assertions let you test your assumptions during development, without the 
	 * expense of writing exception handlers for exceptions that you assume will 
	 * never happen once the program is out of development and fully deployed.
	 */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter an int >= 0: ");
		
		int x = in.nextInt();
		
		methodA(x);
		methodB(x); 
	}
	
	static void methodA(int num) {
		if(num >= 0) {
			System.out.println("great");
		}
		else System.out.println("ERR");
	}
	
	static void methodB(int num) {
		assert(num >= 0): "" + num + " was entered, number less than 0.";
		System.out.println("Assertion passed!");
	}
	
}
