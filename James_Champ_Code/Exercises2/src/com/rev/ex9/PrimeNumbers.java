package com.rev.ex9;

import java.util.ArrayList;

public class PrimeNumbers {
	private boolean[] isPrime;
	private ArrayList<Integer> numbers;
	
	public PrimeNumbers() {
		isPrime = new boolean[101];
		populateIsPrime();
		numbers = new ArrayList<Integer>();
		populateNumbers(101);
	}
	
	public PrimeNumbers(int i) {
		isPrime = new boolean[i + 1];
		populateIsPrime();
		numbers = new ArrayList<Integer>();
		populateNumbers(isPrime.length);
	}
	
	private void populateIsPrime() {
		for(int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		for(int i = 2; i < isPrime.length; i++) {
			for(int j = i + i; j < isPrime.length; j += i) {
				isPrime[j] = false;
			}
		}
	}
	
	private void populateNumbers(int size) {
		for(int i = 1; i < size; i++) {
			numbers.add(i);
		}
	}
	
	public ArrayList<Integer> getPrimes() {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) {
				primes.add(i);
			}
		}
		
		return primes;
	}
	
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}
}
