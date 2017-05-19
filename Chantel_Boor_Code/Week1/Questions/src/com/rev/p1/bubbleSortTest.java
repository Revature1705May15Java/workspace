package com.rev.p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class bubbleSortTest {
	
	//objects used for testing
	problem1 b;
	static problem1 sb;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		System.out.println("in setupBefore");
		sb = new problem1 ();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		System.out.println("in tearDownAfter");
		sb = null;
		
	}

	@Before
	public void setUp() throws Exception 
	{
		b = new problem1 ();
		System.out.println("setup");
	}

	@After
	public void tearDown() throws Exception 
	{
		b = null;
		System.out.println("tearDown");
	}

	//test case that makes sure array we were given ends up sorted in ascending order
	@Test
	public void test()
	{
		int [] input = {1,0,5,6,3,2,3,7,9,8,4};
		int [] expected ={0,1,2,3,3,4,5,6,7,8,9};
		int[] actual = b.sort(input);
		//int[] statactual = sb.sort(input);
		
		assertArrayEquals(expected,actual);
		
		
	}

}
