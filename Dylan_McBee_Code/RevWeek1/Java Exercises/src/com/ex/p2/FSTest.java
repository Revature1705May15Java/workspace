package com.ex.p2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FSTest {

	Fibonacci fs;

	@Before
	public void setUp() throws Exception {
		fs = new Fibonacci();
		System.out.println("in setUp()");
	}

	@After
	public void tearDown() throws Exception {
		fs = null;
	}

	// @Test
	// public void test() {
	// long input = 5;
	// long expected = memes;;
	// int actual = fs.fibonacci(input);
	//
	//
	// }

}
