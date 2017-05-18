package com.ex.exceptions;

import java.util.Scanner;

public class AssertionsEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an int >= 0");
		
		int x = scan.nextInt();
		
		methodA(x);
		methodB(x);
	}
	
	static void methodA(int num) {
		if(num>=0) {
			System.out.println("great");
		} else {
			System.out.println("err");
		}
	}
	
	static void methodB(int num) {
		assert(num>=0): "entered number less than 0";
		System.out.println("great");
	}
}
