package Exceptions;

import java.util.Scanner;

public class assertionPractice 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter an integer value greater than 0");
		
		int n = in.nextInt(); 
		
		methodA(n); 
		methodB(n); 
		
		in.close();
	}
	
	static void methodA(int num)
	{
		if(num > 0)
			System.out.println("great");
		else
			System.out.println("u stoopid");
	}
	
	static void methodB(int num)
	{
		assert(num > 0): "entered number <= 0"; 
		System.out.println("great");
	}
}
