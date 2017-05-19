package com.rev.ex9;

public class Main {

	public static void main(String[] args) {
		PrimeNumbers pm = new PrimeNumbers();
		
		System.out.println("Primes:");
		for(int i : pm.getPrimes()) {
			System.out.println(i);
		}
		
		System.out.println("\nAll Numbers:");
		for(int i : pm.getNumbers()) {
			System.out.println(i);
		}
	}
}
