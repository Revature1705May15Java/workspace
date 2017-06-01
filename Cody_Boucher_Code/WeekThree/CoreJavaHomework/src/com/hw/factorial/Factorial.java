package com.hw.factorial;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number to compute to: ");
		int num = scan.nextInt();
		scan.close();
		int factorial = 1;
		for(int i = 1; i <= num; i++) {
			factorial *= i;
		}
		System.out.println(factorial);	
	}
}
