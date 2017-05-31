package com.rev.q2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciTest {

	int[] fibResults;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fibResults = Fibonacci.fib(5);
	}

	@After
	public void tearDown() throws Exception {
		fibResults = null;
	}

	@Test
	public void test() {
		int[] expected = { 0, 1, 1, 2, 3 };
		
		assertArrayEquals(expected, fibResults);
	}
	

}
