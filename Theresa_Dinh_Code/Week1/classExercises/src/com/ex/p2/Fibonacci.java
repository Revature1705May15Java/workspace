package com.ex.p2;

public class Fibonacci 
{
	public int[] sequence(int x)
	{
		int[] output = new int[x]; 
		
		//preparing start of seq
		int n1 = 0;
		int n2 = 1; 
		output[0] = 0; 
		output[1] = 1; 
		 
		
		for(int i = 2; i < output.length; i++)
		{
			int temp = n2; //store n2 value to set n1 later
			n2 += n1; 
			output[i] = n2; //adds new value to array 
			n1 = temp; 
		}
		
		return output;  
	}

	/*
	public static void main(String[] args)
	{
		int n1 = 0;
		int n2 = 1; 
		System.out.print("0 1 ");
		
		for(int i = 0; i < 5; i++)
		{
			int temp = n2; //store n2 value to set n1 later
			n2 += n1; 
			System.out.print(n2 + " ");
			n1 = temp; 
		}
	}
	*/
}
