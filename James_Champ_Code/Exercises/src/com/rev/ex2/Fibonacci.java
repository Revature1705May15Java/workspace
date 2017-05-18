package com.rev.ex2;

import java.util.LinkedList;

public class Fibonacci {
	
	/**
	 * Creates and returns a LinkedList of the first {@code n} 
	 * elements of the Fibonacci sequence.
	 * 
	 * Precondition: {@code n} must be greater than or equal to 2.
	 * 
	 * @param n		The number of Fibonacci sequence elements that is
	 * 				to be contained in the LinkedList.
	 * @return		A LinkedList of {@code n} sequential Fibonacci numbers.
	 */
	public static LinkedList<Integer> getSequence(int n) {
		int a = 0;
		int b = 1;
		n -= 2;
		
		LinkedList<Integer> result = new LinkedList<Integer>();
		result.add(a);
		result.add(b);
		
		while(n > 0) {
			int temp = a + b;
			a = b; 
			b = temp;
			
			result.add(b);
			--n;
		}
		
		return result;
	}
}
