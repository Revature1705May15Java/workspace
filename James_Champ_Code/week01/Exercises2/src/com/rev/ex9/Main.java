package com.rev.ex9;

public class Main {

	public static void main(String[] args) {
		PrimeNumbers pm = new PrimeNumbers();
		
		System.out.println("Primes:");
		for(int i : pm.getPrimes()) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n\nAll Numbers:");
		for(int i : pm.getNumbers()) {
			System.out.print(i + " ");
		}
	}
}
