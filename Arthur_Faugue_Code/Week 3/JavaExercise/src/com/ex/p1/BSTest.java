package com.ex.p1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BSTest {
	
	BubbleSort b1;

	/*
	 * Confirms the new instance of the BubbleSort class
	 */
	@Before
	public void setUp() throws Exception {
		b1 = new BubbleSort();
		System.out.println("Setting up");
	}
	
	/*
	 * Confirms the BubbleSort class instance is set 
	 * to null
	 */
	@After
	public void tearDown() throws Exception {
		b1 = null;
		System.out.println("Tearing down");
	}

	/*
	 * Used to test that the bubbleSortThis method works
	 * with the given array
	 */
	@Test
	public void bubbleSortTest1() {
		
		int[] Array = {1,0,5,6,3,2,3,7,9,8,4};
		
		int[] ArrayExpect = {0,1,2,3,3,4,5,6,7,8,9};
		
		int[] ArrayActual = b1.BubbleSortThis(Array);
		assertArrayEquals(ArrayExpect, ArrayActual);
	}
	
	/*
	 * Used to test that the bubbleSortThis method works
	 * using another array of int.
	 */
	@Test
	public void bubbleSortTest2() {
		
		int[] Array = {12,30, 5, 55, 25};
		
		int[] ArrayExpect = {5, 12, 25, 30, 55};
		
		int[] ArrayActual = b1.BubbleSortThis(Array);
		assertArrayEquals(ArrayExpect, ArrayActual);
	}

}
