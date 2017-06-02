package com.ex.p9;

import java.util.ArrayList;

public class PrimeNumbers {
	
	/*
	 * This method checks whether or not a given int is a 
	 * prime number, and will return true or false.
	 */
	public boolean isPrime(int n){
		if(n==2){
			return true;
		}
		if(n%2==0){
			return false;
		}
		for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> prime = new ArrayList<Integer>();
		PrimeNumbers iPrime = new PrimeNumbers();
		
		//adds the first 100 numbers to the prime array
		for(int x=1; x<=100; x++){
			prime.add(x);
		}
		for(int y=0; y<prime.size();y++){
			if(iPrime.isPrime(prime.get(y).intValue())){
				System.out.println(prime.get(y).intValue());
			}
		}
		
	}
}
