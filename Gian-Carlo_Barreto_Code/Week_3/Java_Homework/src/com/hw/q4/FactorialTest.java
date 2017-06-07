package com.hw.q4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FactorialTest {
	Factorial f;

	@Before
	public void setUp() throws Exception {
		f = new Factorial();
	}

	@After
	public void tearDown() throws Exception {
		f = null;
	}

	@Test
	public void test() {
		// Which factorial to find
		int num = 5;
		
		// Expected factorial value
		long expected = 120;
		
		// Factorail value that function returns
		long actual = f.fact(num);
		
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		// Which factorial to find
		int num = 14;
		
		// Expected factorial value
		long expected = 87178291200L;
		
		// Factorail value that function returns
		long actual = f.fact(num);
		
		assertEquals(expected, actual);
	}
}
