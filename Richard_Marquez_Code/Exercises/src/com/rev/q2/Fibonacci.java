package com.rev.q2;

public class Fibonacci {

	public static void main(String[] args) {
		fib(25);
	}

	// Iterative Fibonacci
	// Print sequence up to FibN
	public static int[] fib(int n) {
		int[] results = new int[n];
		
		int curr = 1;
		int prev = 0;
		
		if (n < 1) return results;
		System.out.println("0: " + prev);
		results[0] = prev;
		
		if (n < 2) return results;
		System.out.println("1: " + curr);
		results[1] = curr;
		
		
		for (int i = 2; i < n; i++) {
			int newSum = curr + prev;
			results[i] = newSum;
			System.out.println(i + ": " + newSum);
			prev = curr;
			curr = newSum;
		}
		
		return results;
			
	}

}
