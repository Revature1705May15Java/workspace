package com.ex.p3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FactorialTest {
	Factorial f;

	@Before
	public void setUp() throws Exception {
		f = new Factorial();
		System.out.println("SetUp");
	}


	@After
	public void tearDown() throws Exception {
		f = null;
		System.out.println("TearDown");
	}

	@Test
	public void test() {
		int expected = 5040;
		int actual = f.factorial(7);
		assertEquals(expected, actual);
	}

}
