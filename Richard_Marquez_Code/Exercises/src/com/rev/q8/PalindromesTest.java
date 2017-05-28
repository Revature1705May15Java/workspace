package com.rev.q8;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class PalindromesTest {

	@Test
	public void test() {
		ArrayList<String> input = new ArrayList<>();
		input.add("karan");
		input.add("madam");
		input.add("tom");
		input.add("civic");
		input.add("radar");
		input.add("sexes");
		input.add("jimmy");
		input.add("kayak");
		input.add("john");
		input.add("refer");
		input.add("billy");
		input.add("did");
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("madam");
		expected.add("civic");
		expected.add("radar");
		expected.add("sexes");
		expected.add("kayak");
		expected.add("refer");
		expected.add("did");
		
		ArrayList<String> actual = Palindromes.getPalindromes(input);
		System.out.println("expected: " + expected);
		System.out.println("actual: " + actual);
		assertTrue(arrayListEquals(expected, actual));
		
	}
	
	static boolean arrayListEquals(ArrayList<String> arr1, ArrayList<String> arr2) {
		boolean result = true;
		
		if (arr1.size() != arr2.size()) return false;
		
		for (int i = 0; i < arr1.size(); i++) {
			if (!arr1.get(i).equals(arr2.get(i))) {
				result = false;
				break;
			}
		}
		
		return result;
	}

}
