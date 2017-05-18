package com.rev.q3;

public class Factorial {

	public static void main(String[] args) {
		int x = 5;
		System.out.println("Fact(" + x + "): " + fact(x));
	}

	// Recursive factorial
	public static int fact(int n) {
		if (n == 0) return 1;
		else return n * fact(n - 1);
	}
}
