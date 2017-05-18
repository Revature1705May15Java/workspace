package com.ex.p2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ex.p3.factorial;

public class FibonacciTest {

	Fibonacci b;	
	static Fibonacci sb;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("in setUpBeforeClass()");
		sb = new Fibonacci();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("in tearDownAfterClass()");
		sb = null;
	}

	@Before
	public void setUp() throws Exception {
		b = new Fibonacci();
		System.out.println("in setUp()");
		
	}

	@After
	public void tearDown() throws Exception {
		b =null;
		System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		int input = 7;
		
		int[] expected = {0, 1, 1, 2, 3, 5, 8};
		
		int[] actual = b.printFibonacci(input);
		
		assertArrayEquals(expected, actual);
		
	}
	
	@Test
	public void test2() {
		int input = 25;
		
		int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
				144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368 };
		
		int[] actual = b.printFibonacci(input);
		
		assertArrayEquals(expected, actual);
		
	}
}
