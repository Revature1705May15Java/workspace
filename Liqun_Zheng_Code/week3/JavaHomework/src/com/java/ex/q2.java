package com.java.ex;

public class q2 {
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
		q2 i =new q2();
		i.printFibonacci(25);
	}
}
