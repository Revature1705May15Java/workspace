package com.hw.palindromes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Palindromes {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("johm");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		Iterator<String> itr = words.iterator();
		while(itr.hasNext()) {
			String word = itr.next();
			if(Palindromes.isPalindrome(word) == true) {
				palindromes.add(word);
			}
		}
		System.out.print("Palindromes ");
		System.out.print(Arrays.toString(palindromes.toArray()));
	}
	
	public static boolean isPalindrome(String str) {
	    return str.equals(new StringBuilder(str).reverse().toString());
	}
	
}
