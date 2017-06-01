package com.hw.primes;

import java.util.ArrayList;

public class Primes {
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i =1; i <= 100; i++) {
			primes.add(i);
		}
		
		for(int i = 1; i < primes.size(); i++) {
			if(Primes.isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
