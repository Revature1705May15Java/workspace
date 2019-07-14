package com.ex.p2;

public class Fibonacci {
	
	public int fibonacci(int n)  {
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public int[] printFibonacci(int n){
		int[] result = new int[n];
		for(int i =0; i< n; i++){
			System.out.print(fibonacci(i) + " ");
			result[i]=fibonacci(i);
		}
		return result;
	}
	public static void main(String [] args)
	{
		Fibonacci i =new Fibonacci();
		i.printFibonacci(25);
	}
}

