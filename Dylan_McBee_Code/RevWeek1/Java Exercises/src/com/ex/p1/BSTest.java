package com.ex.p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BSTest {

	BubbleSort b;
	
	static BubbleSort sb;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		System.out.println("in setUpBeforeClass()");
		sb = new BubbleSort();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("in tearDownAfterClass()");
		sb = null;
	}

	@Before
	public void setUp() throws Exception {
	b = new BubbleSort();
	System.out.println("in setUp()");
	}
	

	@After
	public void tearDown() throws Exception {
	b = null;
	System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		int[] input = {1,0,5,6,3,2,3,7,9,8,4};
		
		int[] expected = {0,1,2,3,3,4,5,6,7,8,9};
		
		int[] actual = b.sort(input);
		
		assertArrayEquals(expected, actual);
		
	}
	@Test
	public void test2() {
		int[] input = {1,0,5,6,3,2,3,7,9,8,4};
		
		int[] actual = b.sort(input);
		
		boolean n = actual == null;
		
		assertFalse(n);
	}

}
