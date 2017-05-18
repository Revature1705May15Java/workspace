package com.ex.p8;

import java.util.ArrayList;

public class Palindrome 
{
	//given a String array, check to see if any the Strings are palindromes
	public ArrayList<String> palinCheck(String[] words)
	{
		ArrayList<String> pals = new ArrayList<String> (); 
	
		for(String s : words)
		{
			boolean check = true; 
			int matchingLetters = (int)(s.length()/2); 
			for(int i = 0; i < matchingLetters; i++)
			{
				if(s.substring(i, i+1).equalsIgnoreCase(s.substring(s.length()-(i+1), s.length()-i)))
				{
					//System.out.println(s);
					continue;
				}
				else
				{
					check = false; 
					break; 
				}
			}
			if(check)
			{
				pals.add(s); 
				System.out.println(s);
			}
		}
		
		return pals;
	}
}
