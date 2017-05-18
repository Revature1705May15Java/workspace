package com.rev.ex8;

import java.util.ArrayList;

public class StringLists {
	
	private ArrayList<String> palindromes;
	private ArrayList<String> allStrings;
	
	public StringLists(String[] words) {
		palindromes = new ArrayList<String>();
		allStrings = new ArrayList<String>();
		
		for(String s : words) {
			allStrings.add(s);
			
			if(isPalindrome(s)) {
				palindromes.add(s);
			}
		}
	}
	
	public ArrayList<String> getAllStrings() {
		return allStrings;
	}
	
	public ArrayList<String> getPalindromes() {
		return palindromes;
	}
	
	public boolean isPalindrome(String s) { // Changed visibility to public for testing purposes
		boolean isPalindrome = true;
		String test = s.toLowerCase();
		
		for(int i = 0, j = test.length() - 1; i < j && isPalindrome; i++, j--) {
			if(test.charAt(i) != test.charAt(j)) {
				isPalindrome = false;
			}
		}
		
		return isPalindrome;
	}
}
