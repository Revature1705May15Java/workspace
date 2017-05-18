package com.ex.p19;

import java.util.ArrayList;

import com.ex.p9.PrimeNumbers;

public class ArrList {

	public static void main(String[] args) {
		ArrayList<Integer> prime = new ArrayList<Integer>();
		PrimeNumbers iPrime = new PrimeNumbers();
		
		//adds the first 100 numbers to the prime array
		for(int x=1; x<=10; x++){
			prime.add(x);
		}
		int temp = 0;
		for(int y=1;y<prime.size();y=y+2){
			temp = temp + (prime.get(y).intValue());
		}
		System.out.println("Sum of even numbers: " + temp);
		temp = 0;
		for(int y=0;y<prime.size();y=y+2){
			temp = temp + (prime.get(y).intValue());
		}
		System.out.println("Sum of odd numbers: " + temp);
		//prime.get(y).intValue()
		
		for(int z=0;z<prime.size();z++){
			if(iPrime.isPrime(prime.get(z).intValue())){
				prime.remove(z);
			}
		} 
		System.out.println("Array after: " + prime.toString());
	}

}