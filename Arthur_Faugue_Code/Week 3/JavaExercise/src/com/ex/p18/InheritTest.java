package com.ex.p18;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InheritTest {
	Inherit i1;

	/*
	 * Confirms the new instance of the Inherit class
	 */
	@Before
	public void setUp() throws Exception {
		i1 = new Inherit();
		System.out.println("Setting up");
	}

	/*
	 * Confirms the Inherit class instance is set 
	 * to null
	 */
	@After
	public void tearDown() throws Exception {
		i1 = null;
		System.out.println("Tearing down");
	}
	
	/*
	 * Used to test that the bubbleSortThis method works
	 * with the given array of int
	 */
	@Test
	public void bubbleSort() {
		int[] actual = {1,0,5,6,3,2,3,7,9,8,4};
		int[] expect = {0,1,2,3,3,4,5,6,7,8,9};
		
		int[] actual1 = i1.BubbleSortThis(actual); 
		assertArrayEquals(expect, actual1);
	}
	
	/*
	 * Test if a given String will return an int
	 * after the convertToInt method
	 */
	@Test
	public void stringToInt() {
		String actual = "10";
		int expect = 10;
		
		int actual1 = i1.convertToInt(actual); 
		assertEquals(expect, actual1);
	}
	
	/*
	 * Test whether a given int will return false
	 * if the int is not a prime number
	 */
	@Test
	public void isPrimeFail() {
		int actual = 10;
		 
		assertFalse(i1.isPrime(actual));
	}
	
	/*
	 * Test whether a given int will return true
	 * if the int is a prime number
	 */
	@Test
	public void isPrimePass() {
		int actual = 5;
		 
		assertTrue(i1.isPrime(actual));
	}
}
