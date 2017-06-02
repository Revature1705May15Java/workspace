package com.ex.p19;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrListTest {
	ArrList a1;

	/*
	 * Confirms the new instance of the ArrList class
	 */
	@Before
	public void setUp() throws Exception {
		a1 = new ArrList();
		System.out.println("Setting up");
	}

	/*
	 * Confirms the ArrList class instance is set 
	 * to null
	 */
	@After
	public void tearDown() throws Exception {
		a1 = null;
		System.out.println("Tearing down");
	}

	/*
	 * Test to see if all the prime numbers where successfully removed from the 
	 * ArrayList.
	 */
	@Test
	public void testSum() {
		ArrayList<Integer> actual = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		ArrayList<Integer> expect = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 9, 10));
		actual = ArrList.noPrime(actual);
		String actual1 = actual.toString();
		String expect1 = expect.toString();
		assertEquals(actual1, expect1);
		
	}
	
	/*
	 * Checks to see if the sum of all the odd indexes are correct, in this case
	 * the odd indexes are all the even numbers
	 */
	@Test
	public void testEven() {
		ArrayList<Integer> actual = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		int expect = 30;
		int actual1 = ArrList.even(actual);
		assertEquals(actual1, expect);
		
	}
	
	/*
	 * Checks to see if the sum of all the even indexes, starting form index 2, are correct, 
	 * in this case the even indexes are all the even numbers
	 */
	@Test
	public void testOdd() {
		ArrayList<Integer> actual = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		int expect = 25;
		int actual1 = ArrList.odd(actual);
		assertEquals(actual1, expect);
		
	}
}
