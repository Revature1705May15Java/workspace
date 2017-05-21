package com.revature_wk1.palindrome;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindrome 
{
	public void main(String[] args) 
	{
		/*ArrayList<String> input = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes",
				"jimmy", "kayak", "john", "refer", "billy", "did"));*/
		
		ArrayList<String> palindromes = new ArrayList<>();
		
		int i = 0;
		
		for(String str : args)
		{
			str = new StringBuffer(str).reverse().toString();
			if(args[i].equals(str))
			{
				palindromes.add(str);
			}
			
			i++;
		}
		
		System.out.println(palindromes);
	}

}
