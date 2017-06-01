package com.hw.even;

import java.util.Scanner;

public class Even {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter int: ");
		int num = scan.nextInt();
		scan.close();
		//integer divions removes remainder making the numbers not equal when quotient is multiplied by 2
		int quotient = num / 2;
		if(quotient * 2 == num) {
			System.out.println("int is even");
		}
		else {
			System.out.println("int is odd");
		}
	}
}
