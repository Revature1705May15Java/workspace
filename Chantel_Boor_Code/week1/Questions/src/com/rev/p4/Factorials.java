package com.rev.p4;

public class Factorials 
{
	public static void main(String[] args) 
	{
		int num =5;
		int f = CalcF(num);
		
		System.out.println("Factorial is " + f);
		
	}
	
	static int CalcF (int n)
	{
		if(n==0)
			return 1;
		else
			return(n*CalcF(n-1));
	}
}

