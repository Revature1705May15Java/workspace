package com.rev.p15;

import java.text.DateFormat;
import java.util.Date;

public class SwitchStatement 
{

	public static void main(String[] args) 
	{
		int s = 3;
		
		switch(s)
		{
		case 1:
		{
			int square = 25;
			double root = Math.sqrt(square);
			
			System.out.println("Square root of " + square + " is "+root);
			
			break;
		}
		case 2:
		{
			Date date = new Date();
			System.out.println("Today's Date: " + date);
			
			break;
		}
		case 3:
		{
			String original = "I am learning Core Java";
			String [] words = original.split(" ");
			
			for(String curr:words)
			{
				System.out.println(curr);
			}
			
			break;
		}
		default:
		{
			System.out.println("Not a case");
		}
		}
	}
	
}
