package com.ex.p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

	enum Days {M, T, W, Th, Fr};
	
	BubbleSort b;
	
	@Before
	public void setUp() throws Exception {
		b = new BubbleSort();
	}

	@After
	public void tearDown() throws Exception {
		b = null;
	}

	@Test
	public void test() {
		int[] expected = { 0, 1,2, 3, 3, 4 , 5, 6, 7, 8, 9};
		int[] actual = expected;
		System.out.println(actual);
		
		
		assertEquals(expected, actual);
	}

}
