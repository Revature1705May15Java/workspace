package com.revature.palindrome;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindrome 
{
	public static void main(String[] args) 
	{
		ArrayList<String> input = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes",
				"jimmy", "kayak", "john", "refer", "billy", "did"));
		
		ArrayList<String> palindromes = new ArrayList<>();
		
		int i = 0;
		
		for(String str : input)
		{
			str = new StringBuffer(str).reverse().toString();
			if(input.get(i).toString().equals(str))
			{
				palindromes.add(str);
			}
			
			i++;
		}
		
		System.out.println(palindromes);
	}

}
