package com.rev.q8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {
		//
	}
	
	static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		
		return sb.toString().equals(str);
	}
	
	static ArrayList<String> getPalindromes(ArrayList<String> allStrs) {
		ArrayList<String> palindromes = new ArrayList<>();
		
		for (String s : allStrs) {
			if (isPalindrome(s)) {
				palindromes.add(s);
			}
		}
		
		return palindromes;
	}

}
