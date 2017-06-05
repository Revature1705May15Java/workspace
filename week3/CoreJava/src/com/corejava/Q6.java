package com.corejava;

public class Q6 {
/*
Write a program to determine if an 
integer is even without using the 
modulus operator (%)
 */
	
	public static String Q6m(int input) {
		double input2=input;
		if(Math.pow(-1, input2)==1){
			return "Even";
		}else{
			return "Odd";
		}
	}
	

public static void main(String[] args) {
	System.out.println(Q6m(0));
}
}