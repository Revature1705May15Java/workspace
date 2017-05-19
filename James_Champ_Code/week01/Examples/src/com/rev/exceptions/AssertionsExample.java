package com.rev.exceptions;

import java.util.Scanner;

public class AssertionsExample {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number >= 0: ");
		int num = scan.nextInt();
		
		methodA(num);
		methodB(num);
	}
	
	static void methodA(int num) {
		if(num >= 0) {
			System.out.println("great");
		}
		else {
			System.out.println("ERR");
		}
	}
	
	static void methodB(int num) {
		assert(num >= 0) : "Entered number less than zero...";
		System.out.println("great");
	}
}
