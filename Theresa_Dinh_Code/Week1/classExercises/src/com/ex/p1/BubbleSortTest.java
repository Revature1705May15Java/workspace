package com.ex.p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest 
{
	
	BubbleSort b; 
//	static Bubblesort sB; 
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception 
//	{
//		sB = new BubbleSort(); 
//		System.out.println("setup before");
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception 
//	{
//		sB = null; 
//		System.out.println("teardown after");
//	}

	@Before
	public void setUp() throws Exception 
	{
		b = new BubbleSort(); 
		System.out.println("setup"); 
	}

	@After
	public void tearDown() throws Exception 
	{
		b = null;
		System.out.println("teardown");
	}

	@Test
	public void test() 
	{
		int[] input = {1,0,5,6,3,2,3,7,9,8,4};
		int[] output = b.sort(input);
		int[] expected = {0,1,2,3,3,4,5,6,7,8,9};
		
		assertArrayEquals(expected, output);
	}
	
	@Test
	public void test2()
	{
		boolean safetyCheck = false; 
		
		assertFalse(safetyCheck); 
	}

}
