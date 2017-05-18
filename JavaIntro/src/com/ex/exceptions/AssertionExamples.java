package com.ex.exceptions;

import java.util.Scanner;

public class AssertionExamples {
	
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter an integer >= 0:");
		
		int x = in.nextInt();
		
		methodA(x);
		methodB(x);
	}
	
	static void methodA(int num) {
		if (num >= 0) {
			System.out.println("good job");
		} else {
			System.out.println("seriously? do you not know how to count?");
		}
	}
	
	static void methodB(int num) {
		assert(num >= 0): "" + num + " was entered - number less than 0";
		System.out.println();
	}

}
