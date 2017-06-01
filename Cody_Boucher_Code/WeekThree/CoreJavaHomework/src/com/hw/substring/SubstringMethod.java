package com.hw.substring;

import java.util.Scanner;

public class SubstringMethod {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = scan.nextLine();
		System.out.print("Enter index: ");
		int idx = scan.nextInt();
		scan.close();
		System.out.println("\nOriginal String: " + str);
		substringMaker(str, idx);
	}
	
	public static String substringMaker(String str, int idx) {
		String newString = "";
		for(int i = 0; i <= idx-1; i++) {
			newString += str.charAt(i);
		}
		System.out.println("New string: " + newString);
		return newString;
	}
}
