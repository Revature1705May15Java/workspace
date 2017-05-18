package com.revature_wk1.bubblesort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest 
{
	BubbleSort bsTest;

	/*@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}*/

	@Before
	public void setUp() throws Exception 
	{
		bsTest = new BubbleSort();
		System.out.println("Setting up...");
	}

	@After
	public void tearDown() throws Exception 
	{
		bsTest = null;
		System.out.println("Tearing down...");
	}

	@Test
	public void test() 
	{
		int exArray[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		int exArrayExpected[] = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		
		int exArrayActual[] = bsTest.bubbleSort(exArray);
		
		assertArrayEquals(exArrayExpected, exArrayActual);
	}

}
