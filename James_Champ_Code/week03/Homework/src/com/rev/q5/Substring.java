package com.rev.q5;

public class Substring {
	public static void main(String[] args) {
		String s = "some string";
		
		System.out.println(substring(s, 5));
	}
	
	private static String substring(String str, int idx) {
		String result = "";
		
		for(int i = 0; i < idx; i++) {
			result += str.charAt(i);
		}
		
		return result;
	}
}
