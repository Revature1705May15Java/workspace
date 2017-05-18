package com.rev.ex8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetAllStringsTest {
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
		int expected = words.length;
		int actual = stringLists.getAllStrings().size();
		
		// Assert words array size is equal to size of list of all strings
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		boolean actual = stringLists.getAllStrings().contains("Ice cream");
		
		// Assert that string "Ice cream" is not in list of all strings.
		assertFalse(actual);
	}

}
