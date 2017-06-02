package com.ex.p18;

import com.ex.p1.BubbleSort;
import com.ex.p9.PrimeNumbers;

abstract class Inherite{
	
	/*
	 * Creates three abstract methods
	 */
	abstract boolean isPrime(int s);
	abstract int[] BubbleSortThis (int[] bs);
	abstract int convertToInt(String s);
}

public class Inherit extends Inherite{
	
	/*
	 * Extends the abstract method from the abstract class 
	 * Inherite. Checks if a given int is a prime number, uses the
	 * isPrime method from com.ex.p9.PrimeNumbers.
	 */
	@Override
	boolean isPrime(int s) {
		PrimeNumbers iPrime = new PrimeNumbers();
		return iPrime.isPrime(s);
	}
	/*
	 * Extends the abstract method from the abstract class 
	 * Inherite. Returns a sorted array of int using the 
	 * bubble sort algorithm. This method uses the BubbleSortThis
	 * method from the com.ex.p1.BubbleSort.
	 */
	@Override
	int[] BubbleSortThis(int[] bs) {
		BubbleSort bsort = new BubbleSort();
		return bsort.BubbleSortThis(bs);
	}
	
	/*
	 * Extends the abstract method from the abstract class 
	 * Inherite. Creates a method given a String returns the 
	 * Integer equivalent.
	 */
	@Override
	int convertToInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Inherit it = new Inherit();
		String num = "10";
		/*
		 * Used to test the BubbleSortThis method.
		 */
		int[] BSort = {1,0,5,6,3,2,3,7,9,8,4};
		BSort = it.BubbleSortThis(BSort);
		for(int i : BSort){
			System.out.print(BSort[i] + " ");
		}
		
		/*
		 * Used to convert the given string to an 
		 * Integer.
		 */
		System.out.println("\nThis is the string converted to an int: " + it.convertToInt(num));
		
		/*
		 * Uses the String that was converted to an integer to check
		 * if the given is a prime number.
		 */
		if(it.isPrime(it.convertToInt(num))){
			System.out.println(it.convertToInt(num) + " This is a prime number");
		}else{
			System.out.println(it.convertToInt(num) + " This is not a prime number.");
		}
	}
	
	
}
