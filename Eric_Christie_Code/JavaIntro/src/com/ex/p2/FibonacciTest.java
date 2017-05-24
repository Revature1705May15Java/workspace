package com.ex.p2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setting up before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearing down after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setting up");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearing down");
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
		int input = 10;
		
		int[] actual = Fibonacci.fibonacci(input);
		
		int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
		
		assertEquals(input, actual.length);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		int input = 8;
		
		int[] actual = Fibonacci.fibonacci(input);
		
		int[] expected = {0, 1, 1, 2, 3, 5, 8, 13};
		
		assertEquals(input, actual.length);
		assertArrayEquals(expected, actual);
	}

}
