package com.ex.substr;

public class SubString {

	public static void main(String[] args) {
		String string = "stringtest";
		String substring = substring(string, 1, 4);
		System.out.println(substring);
	}
	
	static String substring(String string, int start, int end){
		StringBuilder builder = new StringBuilder();
		
		for(int i =start; i < end; i++){
			builder.append(string.charAt(i));
		}
		return builder.toString();
	}
	
}
