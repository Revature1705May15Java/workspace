package com.ex.p9;

import java.util.ArrayList;
import java.util.Iterator;

public class PrimeNumbers {

	public static void main(String[] args) {
		PrimeNumbers pn = new PrimeNumbers();
		pn.primeNumbers();
		
	}
	
	public void primeNumbers() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 2; i < 101; i++) {
			numbers.add(i);
		}
		Iterator<Integer> itr = numbers.iterator();
		while(itr.hasNext()) {
			int currentNumber = itr.next();
			if(PrimeNumbers.isPrime(currentNumber) == true){
				System.out.println(currentNumber);
			}		
		}
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;

	}
}
