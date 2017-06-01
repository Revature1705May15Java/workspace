package com.rev.q2;

public class Fibonacci {
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int temp;
		
		int count = 2;
		
		System.out.print(a + " " + b);
		
		while(count < 25) {
			temp = a + b;
			a = b;
			b = temp;
			
			System.out.print(" " + b);
			
			count++;
		}
	}
}
