package com.hw.minimum;

import java.util.Scanner;

public class Minimum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter num1: ");
		int num1 = scan.nextInt();
		System.out.println("Enter num2: ");
		int num2 = scan.nextInt();
		scan.close();
		int minval = (num1 < num2) ? num1 : num2;
		System.out.println("The smaller number is: " + minval);	
	}
}
