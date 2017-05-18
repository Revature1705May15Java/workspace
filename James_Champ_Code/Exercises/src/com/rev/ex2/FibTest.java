package com.rev.ex2;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibTest {

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
		LinkedList<Integer> actual = Fibonacci.getSequence(25);
		
		assertNotNull(actual);
	}
	
	@Test
	public void test2() {
		LinkedList<Integer> list = Fibonacci.getSequence(25);
		int expected = 25;
		int actual = list.size();
		
		assertEquals(actual, expected);
	}

}
