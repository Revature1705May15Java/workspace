package com.hw.q6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EvenTest {
	Even even;
	
	@Before
	public void setUp() throws Exception {
		even = new Even();
	}

	@After
	public void tearDown() throws Exception {
		even = null;
	}

	@Test
	public void test() {
		// Input number
		int input = 8;
		
		// Actual result
		boolean actual = even.isEven(input);
		
		// Check to see if actual is true
		assertTrue(actual);
	}
	
	@Test
	public void tes2t() {
		// Input number
		int input = 3;
		
		// Actual result
		boolean actual = even.isEven(input);
		
		// Check to see if actual is false
		assertFalse(actual);
	}

}
