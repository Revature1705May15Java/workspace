package com.ex.p3;

public class Factorial {
	public static void main(String[] args) {
		//Factorial f = new Factorial();
		//f.factorial(7);
	}
	
	public int factorial(int num) {
		int factorial = 1;
		for(int i = 1; i <= num; i++) {
			factorial = factorial * i;
		}
		System.out.println(factorial);
		return factorial;
	}
}
