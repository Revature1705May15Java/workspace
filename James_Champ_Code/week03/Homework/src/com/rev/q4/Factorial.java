package com.rev.q4;

public class Factorial {
	private static final int N = 6;
	
	public static void main(String[] args) {
		System.out.println(factorial(N));
	}
	
	private static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		else {
			int result = n;
			
			for(int i = n - 1; i > 0; i--) {
				result *= i;
			}
			
			return result;
		}
	}
}
