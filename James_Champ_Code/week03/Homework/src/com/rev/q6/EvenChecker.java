package com.rev.q6;

public class EvenChecker {
	private static final int TEST = 111;
	
	public static void main(String[] args) {
		System.out.println(isEven(TEST) ? "Even" : "Odd");
	}
	
	private static boolean isEven(int n) {
		return (n & 1) == 0;
	}
}
