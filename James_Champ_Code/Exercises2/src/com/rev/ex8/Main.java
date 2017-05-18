package com.rev.ex8;

public class Main {

	public static void main(String[] args) {
		String[] words = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did" };
		
		StringLists lists = new StringLists(words);
		
		System.out.println("All Strings:");
		for(String s : lists.getAllStrings()) {
			System.out.println(s);
		}
		
		System.out.println("\nAll Palindromes:");
		for(String s : lists.getPalindromes()) {
			System.out.println(s);
		}
	}
}
