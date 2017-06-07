package com.hw.q5;

/**
 * Write a substring method that accepts a string str and an integer idx and 
 * returns the substring contained between 0 and idx-1 inclusive.  
 * Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
 * @author Gian-Carlo
 *
 */
public class Substring {
	public static void main(String[] args) {
		String str = "Hello";
		int idx = 5;
		System.out.println(substring(str, idx));
	}
	
	public static String substring(String str, int idx) {
		String sub = "";
		for (int i = 0; i < idx; i++) {
			sub += str.charAt(i);
		}
		return sub;
	}
}
