package com.ex.p8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListPalindrome {
	public static void main(String [] args) {
		ArrayListPalindrome alp = new ArrayListPalindrome();
		alp.getPalindromes();	
	}
	
	public ArrayList<String> getPalindromes() {
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
		while (itr.hasNext()) {
			String word = itr.next();
			if(ArrayListPalindrome.isPalindrome(word) == true) {
				System.out.println("found palindrome");
				palindromes.add(word);
			}
			else {
				System.out.println("nope");
			}
			
		}
		System.out.println("All palindromes");
		System.out.println(Arrays.toString(palindromes.toArray()));
		return palindromes;
	}
	
	public static boolean isPalindrome(String str) {
	    return str.equals(new StringBuilder(str).reverse().toString());
	}
}
