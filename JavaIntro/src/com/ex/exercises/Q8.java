package com.ex.exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class Q8 {

	static ArrayList<String> strings = (ArrayList<String>) Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did");
			
	static ArrayList<String> getPalindromes(ArrayList<String> strs) {
		ArrayList<String> palindromes = new ArrayList<String>();
		for (String s: strs) {
			if (s.equals((new StringBuilder(s)).reverse().toString())) {
				palindromes.add(s);
			}
		}
		return palindromes;

	}
	
	public static void main(String[] args) {
		System.out.println(getPalindromes(strings));
	}

}
