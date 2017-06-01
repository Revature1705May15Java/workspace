package com.hw.arraylist_numbers;

import java.util.ArrayList;

public class ArrayListNumber {
	public static void main(String[] args) {
		ArrayList<Integer> Original = new ArrayList<Integer>();
		int evenCount = 0;
		int oddCount = 0;
		for(int i = 0; i <= 10; i++) {
			Original.add(i);
		}
		
		System.out.println("Original");
		System.out.println(Original);
		
		for(int i = 1; i < Original.size(); i++) {
			if(i % 2 == 0) {
				evenCount += i;
			}
			else {
				oddCount += i;
			}
		}
		
		System.out.println("\nEven number total: " + evenCount);
		System.out.println("Odd number total: " + oddCount + "\n");
		
		
	
		for(int i = 1; i < Original.size(); i++) {
			if(ArrayListNumber.isPrime(Original.get(i))) {
				Original.remove(i);
			}
		}
		
		System.out.println("Remaining Numbers");
		System.out.println(Original);
	}
		
	
	
	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
