package com.corejava;
/*
Write a program to compute N factorial.
 */
public class Q4 {
	public int Factorial(int facnum){
		if(facnum==1){
			return 1;
		}
		return facnum*Factorial(facnum-1);
	}
	
}
