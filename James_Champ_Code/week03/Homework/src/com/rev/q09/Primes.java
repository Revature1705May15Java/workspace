package com.rev.q09;

import java.util.ArrayList;

public class Primes {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
		
		boolean[] sieve = new boolean[101];
		for(int i = 2; i < sieve.length; i++) {
			sieve[i] = true;
		}
		
		for(int i = 2; i < sieve.length; i++) {
			if(sieve[i]) {
				for(int j = i + i; j < sieve.length; j += i) {
					sieve[j] = false;
				}
			}
		}
		
		System.out.println("Primes: ");
		for(int i : numbers) {
			if(sieve[i]) {
				System.out.print(i + " ");
			}
		}
	}
}
