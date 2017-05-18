package com.ex.p1;

public class nFactorial {
	
	
	public int Factorial(int facnum){
		if(facnum==1){
			return 1;
		}
		return facnum*Factorial(facnum-1);
	}
}
