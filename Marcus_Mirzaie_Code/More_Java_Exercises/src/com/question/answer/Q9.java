package com.question.answer;

import java.util.ArrayList;

// Create an ArrayList which stores numbers from 1 to 100
// and prints out all the prime numbers to the console.

public class Q9 {

	ArrayList<Integer> numbers;
	
	Q9(){
		numbers = new ArrayList<Integer>();
	}
	
	ArrayList<Integer> getPrimes(int i, int x){
		
		for(; i<=x; i++){
			numbers.add(i);
		}
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(Integer p: numbers){
			boolean isPrime = true;
			for(int z = 2; z<p;z++)
				if(p%z == 0){
					isPrime = false;
				}
			if(isPrime)
				primes.add(p);
//				System.out.println(p);
		}
		
		return primes;
	}
	
}
