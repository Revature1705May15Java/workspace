package com.ex.p9;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrimeNumbersTest {
	PrimeNumbers p1;

	/*
	 * Confirms the instance of the PrimeNumbers is set up
	 */
	@Before
	public void setUp() throws Exception {
		p1 = new PrimeNumbers();
		System.out.println("Setting up");
	}
	
	/*
	 * Confirms the instance of the PrimeNumbers is null
	 */
	@After
	public void tearDown() throws Exception {
		p1 = null;
		System.out.println("Treaing down");
	}

	/*
	 * Test if the given int is not prime
	 */
	@Test
	public void testPrimeFalse() {
		int actual = 10;
		boolean expect = p1.isPrime(actual);
		assertFalse(expect);
	}
	
	/*
	 * Test if the given int is prime
	 */
	@Test
	public void testPrimeTrue() {
		int actual = 5;
		boolean expect = p1.isPrime(actual);
		assertTrue(expect);
	}

}
