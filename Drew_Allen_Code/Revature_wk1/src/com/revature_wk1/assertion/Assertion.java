package com.revature_wk1.assertion;

import java.util.Scanner;

public class Assertion 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number: ");
		
		int x = in.nextInt();
		
		methodA(x);
		methodB(x);
	}
	
	static void methodA(int num)
	{
		if(num >= 0)
			System.out.println("Greater than/equal to 0");
		else
			System.out.println("ERROR!");
	}
	
	static void methodB(int num)
	{
		assert(num>=0);
		System.out.println("Great!");
	}

}
