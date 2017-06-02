package com.ex.p2;

public class Fibonacci {
	
	/*
	 * The method Fib() takes in a int that is input by the user
	 * to indicate how many numbers of the fibonacci sequence
	 * the user wants to see. Then returns the number of the 
	 * last fibonacci sequence shown.
	 */
	 int Fib(int num){
		
		int Temp = 0;
		int Current = 1; 
		int Previous = 0;
		int Check;
		
		for(int i = 0; i < num; i++) 
		{
			
			if(i==0 || i==1){
				System.out.println("Sequence " + i + " : " + i);
			}else{
				Temp = Current + Previous;
				Check = i + 1;
				System.out.println("Sequence " + Check + " : " + Temp);
				Previous = Current;
				Current = Temp;
			}
	    }
		return Temp;
	}
	
	public static void main(String[] args) {
		// Create initial numbers
		Fibonacci Fibo = new Fibonacci();
		Fibo.Fib(25);
		
		
	}
}
