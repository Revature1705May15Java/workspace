package com.rev.p8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
		//lists used to store string data
		ArrayList <String> words = new ArrayList<String>();
		ArrayList <String> pali = new ArrayList<String>();
		
		Palindromes p= new Palindromes ();
		
		//set up original array list
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		//method call
		pali = p.findPali(words);
		
		
		for(int i=0;i<pali.size();i++)
		{
			System.out.println(pali.get(i));
		}
	}
	
	ArrayList<String> findPali(ArrayList<String> words)
	{
		//array list to store answer and return
		ArrayList <String> pali = new ArrayList<String>();
		
		//loop goes through all elements in the list
		for(int i=0;i<words.size();i++)
		{
			//creates a string and reverse string to compare from current list index
			String n = words.get(i);
			String r = new StringBuilder(n).reverse().toString();
			
			//adds items to pali list if they are a palindrome (same regular and reverse)
			if(n.compareTo(r)==0)
			{
				pali.add(r);
			}
		}
		
		return pali;
		
	}

}
