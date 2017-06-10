package com.rev.p12;

import java.util.ArrayList;

public class IntArray 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> ai = new ArrayList<Integer>();
		
		for(int i = 0; i<=100;i++)
		{
			ai.add(i);
		}
		
		for(Integer i:ai)
		{
			if(i%2 == 0)
			System.out.println(i);
		}
	}
	
}
