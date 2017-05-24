package com.ex.exercises;

import java.util.ArrayList;

public class Q9 {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			nums.add(i);
			if (i != 1) {
				boolean isPrime = true;
				for (Integer p: primes) {
					if (i % p == 0) {
						isPrime = false;
					}
				}
				if (isPrime) {
					System.out.println(i);
					primes.add(i);
				}
			}
		}
	}

}
