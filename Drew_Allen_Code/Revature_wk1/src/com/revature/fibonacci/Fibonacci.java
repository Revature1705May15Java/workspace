package com.revature.fibonacci;

import java.util.Scanner;

public class Fibonacci 
{
	public static long fibonacci(int primeFib)
	{
		if(primeFib <= 1)
			return primeFib;
		else
			return fibonacci(primeFib-1) + fibonacci(primeFib-2);
	}

	public static void main(String[] args) 
	{
		
		Scanner scantron = new Scanner(System.in);
		Fibonacci fib = new Fibonacci();
		System.out.println("Enter a number: ");
		int primeFib = scantron.nextInt();
		for (int i = 0; i < primeFib; i++)
		{
			System.out.printf("Fibbonacci number of %d is: %d\n", i, (fib.fibonacci(i)));
		}
		
		scantron.close();
	}

}
