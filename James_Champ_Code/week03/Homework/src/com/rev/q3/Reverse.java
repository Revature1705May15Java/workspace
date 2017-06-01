package com.rev.q3;

public class Reverse {
	public static void main(String[] args) {
		String s = "some string";
		int length = s.length();
		
		for(int i = length - 1; i >= 0; i--) {
			s += s.charAt(i);
		}
		
		s = s.substring(length, s.length());
		
		System.out.println(s);
	}
}
