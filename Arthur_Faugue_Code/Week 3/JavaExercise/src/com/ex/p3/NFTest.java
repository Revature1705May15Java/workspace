package com.ex.p3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NFTest {
	
	NFactorial n1;
	
	/*
	 * Confirms the instance of the NFactorial is set up
	 */
	@Before
	public void setUp() throws Exception {
		n1 = new NFactorial();
		System.out.println("Setting Up");
	}

	/*
	 * Confirms the instance of the DataFile is set to null
	 */
	@After
	public void tearDown() throws Exception {
		n1 = null;
		System.out.println("Tearing Down");
	}

	/*
	 * Test if the given number is return as it's own
	 * factorial
	 */
	@Test
	public void testFactorial() {
		int actual = 10;
		int expect = 3628800;
		
		actual = n1.Factorial(actual);
		assertEquals(expect, actual);
	}

}
