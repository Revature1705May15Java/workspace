package com.rev.exceptions;

import java.util.Scanner;

public class AssertionEX
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner (System.in);
		System.out.println("enter an int >= 0");
		
		int x = in.nextInt();
		
		methodA(x);
		methodB(x);
	}
	
	static void methodA(int num)
	{
		if(num>0)
			System.out.println("Great");
		else
			System.out.println("ERR");
	}
	
	static void methodB (int num)
	{
		assert(num>=0):"" + num + " was entered - number less than 0";
		System.out.println("Great");
	}
}
