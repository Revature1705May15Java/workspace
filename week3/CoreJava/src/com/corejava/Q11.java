package com.corejava;

import com.floats.FloatHolder;

public class Q11 {
/*
Write a program that would access two float-variables 
from a class that exists in another package. 
Note, you will need to create two packages 
to demonstrate the solution.

 */
	public static void main(String[] args) {
		System.out.println(""+FloatHolder.f1+" "+FloatHolder.f2);
	}
}
