package com.rev.q18;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringCheckerTest {

	StringChecker sc;
	
	@Before
	public void setUp() throws Exception {
		sc = new StringChecker();
	}
	
	@After
	public void tearDown() throws Exception {
		sc = null;
	}

	@Test
	public void testHasUpper() {
		String input1 = "asdf";
		String input2 = "asDf";
		String input3 = "ASDF";
		String input4 = "";
		String input5 = null;
		
		boolean expected1 = false;
		boolean expected2 = true; 
		boolean expected3 = true;
		boolean expected4 = false;
		boolean expected5 = false;
		
		boolean actual1 = sc.hasUpper(input1);
		boolean actual2 = sc.hasUpper(input2);
		boolean actual3 = sc.hasUpper(input3);
		boolean actual4 = sc.hasUpper(input4);
		boolean actual5 = sc.hasUpper(input5);
		
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
		assertEquals(expected4, actual4);
		assertEquals(expected5, actual5);
	}
	
	@Test
	public void testToUpper() {
		String input1 = "asdf";
		String input2 = "asDf";
		String input3 = "ASDF";
		String input4 = "";
		String input5 = null;
		
		String expected1 = "ASDF";
		String expected2 = "ASDF";
		String expected3 = "ASDF";
		String expected4 = "";
		String expected5 = null;
		
		String actual1 = sc.toUpper(input1);
		String actual2 = sc.toUpper(input2);
		String actual3 = sc.toUpper(input3);
		String actual4 = sc.toUpper(input4);
		String actual5 = sc.toUpper(input5);
		
		assertTrue(expected1.equals(actual1));
		assertTrue(expected2.equals(actual2));
		assertTrue(expected3.equals(actual3));
		assertTrue(expected4.equals(actual4));
		assertTrue(expected5 == actual5);
	}
	
	@Test
	public void testToIntPlus10() {
		String input1 = "1";
		String input2 = "-1";
		String input3 = "1 ";
		String input4 = "23";
		String input5 = "";
		String input6 = null;
		
		int expected1 = 1;
		int expected2 = -1;
		int expected3 = 1;
		int expected4 = 23;
		
		int actual1 = sc.toIntPlus10(input1);
		int actual2 = sc.toIntPlus10(input2);
		int actual3 = sc.toIntPlus10(input3);
		int actual4 = sc.toIntPlus10(input4);
		
		try {
			sc.toIntPlus10(input5);
			fail("Should not reach this point");
		} catch(Exception e) {
			//
		}
		
		try {
			sc.toIntPlus10(input6);
			fail("Should not reach this point");
		} catch(Exception e) {
			//
		}

	}

}
