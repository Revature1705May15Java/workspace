package com.ex.p8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {
	Palindrome p1;

	/*
	 * Confirms the instance of the Palindrome is set up
	 */
	@Before
	public void setUp() throws Exception {
		p1 = new Palindrome();
		System.out.println("Setting up");
	}

	/*
	 * Confirms the instance of the Palindrome is set to null
	 */
	@After
	public void tearDown() throws Exception {
		p1 = null;
		System.out.println("Treaing down");
	}

	/*
	 * Test whether the given ArrayList will return only the palindromes
	 */
	@Test
	public void testPalindrome() {
		ArrayList<String> actual = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", 
				"civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		ArrayList<String> expect = new ArrayList<String>(Arrays.asList("madam", "civic", "radar", "sexes", 
				"kayak", "refer", "did"));
		
		String actual1 = p1.returnPalindromeArray(actual);
		String expect1 = expect.toString();
		
		assertEquals(expect1, actual1);
		
	}

}
