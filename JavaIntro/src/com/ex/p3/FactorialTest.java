package com.ex.p3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactorialTest {

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
		int expected = 3628800;
		int actual = Factorial.factorial(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		int input = 5;
		int expected = 120;
		int actual = Factorial.factorial(input);
		
		assertEquals(expected, actual);
	}

}
