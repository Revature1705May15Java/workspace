package com.ex.p2;

public class Fibonacci {
	
	 int Fib(){
		
		int Temp = 0;
		int Current = 1; 
		int Previous = 0;
		int Check;
		
		for(int i = 0; i < 25; i++) 
		{
			// Initiate the fibonacci sequence
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
		Fibo.Fib();
		
		
	}
}
