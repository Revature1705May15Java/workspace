package com.corejava;

public class Q10 {
/*
Find the minimum of two numbers using ternary operators.
 */
	static int Q10m(int n1, int n2){
		return n1<n2?n1:n2;
	}
	
	public static void main(String[] args) {
		System.out.println(Q10m(1,1));
	}
}
