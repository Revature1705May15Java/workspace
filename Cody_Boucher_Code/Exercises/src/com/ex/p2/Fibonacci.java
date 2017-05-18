package com.ex.p2;

public class Fibonacci {
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		f.fibonacci(5);
	}
	
	public int fibonacci(int num) {
		if(num == 0 || num == 1) {
			return 1;
		}
		else {
			 return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}
}
