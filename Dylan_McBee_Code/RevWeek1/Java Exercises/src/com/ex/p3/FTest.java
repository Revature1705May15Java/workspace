package com.ex.p3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FTest {

	Factorial f;

	@Before
	public void setUp() throws Exception {
		f = new Factorial();
		System.out.println("in setUp()");

	}

	@After
	public void tearDown() throws Exception {

		f = null;
		System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		int input = 5;
		int expected = 120;
		int actual = f.fact(input);
		assertEquals(expected, actual);
		System.out.println(actual);
	}

}
