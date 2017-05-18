package com.ex.p4;

import java.util.ArrayList;

public class Palindrome {

	
	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<String>();
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
		ArrayList<String> palindrome = new ArrayList<String>();

		int i = 0;
        
        for(String str : words)
        {
            str = new StringBuffer(str).reverse().toString();
            if(words.get(i).toString().equals(str))
            {
                palindrome.add(str);
            }
            
            i++;
        }
        
        System.out.println(palindrome);

		
	} 
	
}
