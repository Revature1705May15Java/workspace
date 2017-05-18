package com.ex.p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest {
	BubbleSort b;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		b = new BubbleSort();
		System.out.println("SetUp");
	}

	@After
	public void tearDown() throws Exception {
		b = null;
		System.out.println("TearDown");
	}

	@Test
	public void test() {
		int[] input = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int [] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int [] actual = b.sort(input);
		assertArrayEquals(expected, actual);
	}

}
