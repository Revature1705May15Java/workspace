package com.rev.q19;

import java.util.ArrayList;
import com.rev.q9.*;

public class ArrSummations {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			arr.add(i);
		}
		
		System.out.println("Original: " + arr);
		
		System.out.println("Even sum: " + addEvens(arr));
		System.out.println("Odd sum: " + addOdds(arr));
		
		
		// Remove primes
		ArrayList<Integer> noPrimes = removePrimes(arr);
		System.out.println("No primes: " + noPrimes);
	}
	
	public static ArrayList<Integer> removePrimes(ArrayList<Integer> arr) {
		ArrayList<Integer> noPrimes = new ArrayList<>();
		
		for (Integer i : arr) {
			if (!Primes.isPrime(i)) {
				noPrimes.add(i);
			}
		}
		
		return noPrimes;
	}
	
	public static int addEvens(ArrayList<Integer> arr) {
		int sum = 0;
		
		for (Integer i : arr) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
	
	public static int addOdds(ArrayList<Integer> arr) {
		int sum = 0;
		
		for (Integer i : arr) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		
		return sum;
	}
}
