package com.hw.q3;

/**
 * Reverse a string without using a temporary variable. 
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 * @author Gian-Carlo
 * 
 */
public class ReverseString {
	public static void main(String[] args) {
		String token = "a car drives";
		System.out.println(reverse(token));
	}
	
	public static String reverse(String token) {
		String rev = "";
		for (int i = token.length() - 1; i >= 0; i--) {
			rev += token.charAt(i);
		}
		return rev;
	}
}
