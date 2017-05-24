package com.ex.p3;

public class Factorial {
	
	static int factorial(int N) {
		if (N == 1) {
			return 1;
		} else {
			return N*factorial(N-1);
		}
	}

}
