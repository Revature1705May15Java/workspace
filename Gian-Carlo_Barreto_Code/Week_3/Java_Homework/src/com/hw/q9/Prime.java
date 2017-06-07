package com.hw.q9;

import java.util.ArrayList;

/*
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
 */
public class Prime {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++)
			numbers.add(i);
		displayPrimes(numbers);
	}
	
	/*
	 * Displays all the prime numbers in the ArrayList
	 */
	public static void displayPrimes(ArrayList<Integer> numbers) {
		for (int n : numbers) {
			if (isPrime(n))
				System.out.print(n + " ");
		}
	}
	
	/*
	 * Checks to see if a number is prime
	 */
	public static boolean isPrime(int n) {
		if (n == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
