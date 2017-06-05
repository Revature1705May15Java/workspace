package com.rev.q08;

import java.util.ArrayList;

public class Palindrome {

	public static void main(String[] args) {
		String[] words = {"karen", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> fullList = new ArrayList<String>();
		ArrayList<String> palindromeList = new ArrayList<String>();
		
		for(String s : words) {
			fullList.add(s);
			
			if(isPalindrome(s)) {
				palindromeList.add(s);
			}
		}
		
		System.out.println("Full list: ");
		for(String s : fullList) {
			System.out.print(s + " ");
		}
		System.out.println("\n");
		
		System.out.println("Palindrome List: ");
		for(String s : palindromeList) {
			System.out.print(s + " ");
		}
	}
	
	private static boolean isPalindrome(String s) {
		boolean result = true;
		
		for(int i = 0, j = s.length() - 1; i < j && result; i++, j--) {
			if(s.charAt(i) != s.charAt(j)) {
				result = false;
			}
		}
		
		return result;
	}
}
