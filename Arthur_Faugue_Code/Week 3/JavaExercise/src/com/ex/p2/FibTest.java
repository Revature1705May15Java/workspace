package com.ex.p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibTest {
	Fibonacci f1;
	
	/*
	 * Confirms the new instance of the FibTest class
	 */
	@Before
	public void setUp() throws Exception {
		f1 = new Fibonacci();
		System.out.println("Setting Up");
	}

	/*
	 * Confirms the FibTest class instance is set 
	 * to null
	 */
	@After
	public void tearDown() throws Exception {
		f1 = null;
		System.out.println("Tearing Down");
	}

	/*
	 * Checks if the last number in the fibonacci sequence is correct
	 */
	@Test
	public void test() {
		int expect = 46368;
		int actual = f1.Fib(25);
		assertEquals(expect, actual);
	}
	
	/*
	 * Checks if the last number in the fibonacci sequence is incorrect
	 */
	@Test
	public void testFail() {
		int expect = 4636;
		int actual = f1.Fib(25);
		assertNotSame(expect, actual);
	}

}
