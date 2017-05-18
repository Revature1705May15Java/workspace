package com.rev.q9;

import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<>();
		
		for (int i = 1; i <= 100; i++) {
			input.add(i);
		}
		
		System.out.println("PRIMES:");
		for (Integer n : input) {
			if (isPrime(n)) {
				System.out.println(n);
			}
		}
	}
	
	public static ArrayList<Integer> getPrimes(int lower, int upper) {
		ArrayList<Integer> primes = new ArrayList<>();
		
		for (int i = lower; i <= upper; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		
		return primes;
	}
	
	public static boolean isPrime(int n) {
		boolean result = true;
		
		Double primeSquareRoot = Math.sqrt(n);
		
		for (long j = 2; j <= primeSquareRoot.longValue(); j++) {
			if (n % j == 0) {
				result = false;
				break;
			}
		}
		
		return result;
	}

}
