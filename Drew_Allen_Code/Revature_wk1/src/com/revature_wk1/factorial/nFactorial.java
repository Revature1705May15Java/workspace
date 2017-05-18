package com.revature_wk1.factorial;

import java.util.Scanner;

public class nFactorial 
{
	int Factorial (int n)
	{
		if(n==0 || n==1)
			return 1;
		
		n = Factorial(n-1) * n;
		return n;
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		nFactorial nF = new nFactorial();
		System.out.println("Enter a number: ");
		int n_Fact = scan.nextInt();
		nF.Factorial(n_Fact);
		System.out.println(nF.Factorial(n_Fact));
		
		scan.close();
	}
}
