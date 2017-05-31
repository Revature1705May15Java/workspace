package com.rev.q4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactorialTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		boolean n0 = Factorial.fact(0) == 1;
		assertTrue(n0);
		
		boolean n1 = Factorial.fact(1) == 1;
		assertTrue(n1);
		
		boolean n5 = Factorial.fact(5) == 120;
		assertTrue(n5);
	}

}
