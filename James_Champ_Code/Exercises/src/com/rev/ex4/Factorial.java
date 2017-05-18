package com.rev.ex4;

public class Factorial {

	/**
	 * Returns the factorial value of the given integer.
	 * 
	 * Precondition: {@code n} must be greater than 0.
	 * 
	 * @param n		An integer that will undergo the factorial function.
	 * @return		The factorial value of the given integer.
	 */
	public static int factorial(int n) {
		if(n == 1) {
			return n;
		}
		else {
			return n * factorial(n - 1);
		}
	}
}
