package com.ex.p19;

import java.util.ArrayList;

import com.ex.p9.PrimeNumbers;

public class ArrList {
	
	/*
	 * Given an ArrayList if Intergers the even() mehtod
	 * will return the sum of the even numbers assuming
	 * that the given ArrayList starts with the number 1
	 * and increments by 1. 
	 */
	static int even(ArrayList<Integer> prime){
		int temp = 0;
		for(int y=1;y<prime.size();y=y+2){
			temp = temp + (prime.get(y).intValue());
		}
		return temp;
	}
	
	/*
	 * Given an ArrayList if Intergers the odd() mehtod
	 * will return the sum of the odd numbers assuming
	 * that the given ArrayList starts with the number 1
	 * and increments by 1. 
	 */
	static int odd(ArrayList<Integer> prime){
		int temp = 0;
		for(int y=0;y<prime.size();y=y+2){
			temp = temp + (prime.get(y).intValue());
		}
		return temp;
	}
	
	/*
	 * Given an ArrayList of integers this method returns a new 
	 * ArrayList without any prime numbers. This is done using the 
	 * isPrime method from the PrimeNumbers class in the 
	 * com.ex.p9.PrimeNumbers package.
	 */
	static ArrayList<Integer> noPrime(ArrayList<Integer> prime){
		PrimeNumbers iPrime = new PrimeNumbers();
		for(int z=0;z<prime.size();z++){
			if(iPrime.isPrime(prime.get(z).intValue())){
				prime.remove(z);
			}
		} 
		return prime;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> prime = new ArrayList<Integer>();
		
		
		//adds the first 100 numbers to the prime array
		for(int x=1; x<=10; x++){
			prime.add(x);
		}
		
		int temp = even(prime);
		System.out.println("Sum of even numbers: " + temp);
		
		temp = odd(prime);
		System.out.println("Sum of odd numbers: " + temp);
		
		prime = noPrime(prime);
		System.out.println("Array after: " + prime.toString());
	}

}