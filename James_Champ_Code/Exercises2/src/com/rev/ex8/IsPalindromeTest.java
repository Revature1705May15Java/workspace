package com.rev.ex8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IsPalindromeTest {
	private static String[] words = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did" };
	private StringLists stringLists;

	@Before
	public void setUp() throws Exception {
		stringLists = new StringLists(words);
	}

	@After
	public void tearDown() throws Exception {
		stringLists = null;
	}
	
	@Test
	public void test() {
		String s = "banana";
		
		boolean actual = stringLists.isPalindrome(s);
		assertFalse(actual);
	}
	
	@Test
	public void test2() {
		String s = "Klllk";
		
		boolean actual = stringLists.isPalindrome(s);
		assertTrue(actual);
	}
}
