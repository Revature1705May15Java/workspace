package com.ex.p3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ex.pl.BubbleSort;

public class BSTest {
	factorial b;	
	static factorial sb;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("in setUpBeforeClass()");
		sb = new factorial();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("in tearDownAfterClass()");
		sb = null;
	}

	@Before
	public void setUp() throws Exception {
		b = new factorial();
		System.out.println("in setUp()");
		
	}

	@After
	public void tearDown() throws Exception {
		b =null;
		System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		int input = 5;
		
		int expected = 120;
		
		int actual = b.fac(input);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void test2() {
		int input = 10;
		
		int actual = b.fac(input);
		boolean n = actual == 0;
		
		assertFalse(n);
		
	
	}
	@Test
	public void test3() {
		int input = 10;
		
		int expected = 3628800;
		
		int actual = b.fac(input);
		
		assertEquals(expected, actual);
		
	}

}
