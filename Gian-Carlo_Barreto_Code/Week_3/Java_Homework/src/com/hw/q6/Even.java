package com.hw.q6;

/**
 * Write a program to determine if an integer is even without using the modulus operator (%)
 * @author Gian-Carlo
 *
 */
public class Even {
	public static void main(String[] args) {
		int num = 100068;
		if (isEven(num))
			System.out.println("Even");
		else 
			System.out.println("Odd");
	}
	
	public static boolean isEven(int num) {
		return ((num & 1) == 0);
	}
}
