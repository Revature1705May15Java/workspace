package com.rev.lambdas;

import java.util.Scanner;

public class LambdaAssignment {

	public static void main(String[] args) {
		RectArea calc = (int l, int w) -> l * w;
		
		int length = 4;
		int width = 3;
		
		System.out.println("A rectangle with a length of " + length + " and a width of " + 
							width + " has an area of " + calc.getArea(length, width) + ".\n");
		
		Counter c = (String s) -> {	Scanner scan = new Scanner(s);
									int count = 0;
									
									while(scan.hasNext()) {
										scan.next();
										count++; 
									}
									
									return count; };
	
		String testString = "There are seven words in this string.";
		System.out.println("Test String:");
		System.out.println(testString);
		System.out.println("\ntestString contains " + c.countWords(testString) + " words.");
	}
	
}

interface RectArea {
	abstract int getArea(int length, int width);
}

interface Counter {
	abstract int countWords(String s);
}
