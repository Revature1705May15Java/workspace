package com.hw.q3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseTest {
	ReverseString rev;
	@Before
	public void setUp() throws Exception {
		rev = new ReverseString();
	}

	@After
	public void tearDown() throws Exception {
		rev = null;
	}

	@Test
	public void test() {
		// Input string
		String input = "Hello";
		
		// Expected string
		String expected = "olleH";
		
		// Actual string from method
		String actual = rev.reverse(input);
		
		// Checks if the expected and actual strings are equal
		assertEquals(expected, actual);
	}

}
