package com.rev.ex9;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetPrimesTest {
	private PrimeNumbers pn;

	@Before
	public void setUp() throws Exception {
		pn = new PrimeNumbers();
		System.out.println("pn created...");
	}

	@After
	public void tearDown() throws Exception {
		pn = null;
		System.out.println("pn nullified...");
	}

	@Test
	public void test() {
		ArrayList<Integer> primes = pn.getPrimes();
		
		boolean actual = primes.contains(4);
		
		// Ensure that 4 is not in the list of primes
		assertFalse(actual);
	}
	
	@Test
	public void test2() {
		ArrayList<Integer> primes = pn.getPrimes();
		
		boolean actual = primes.contains(13);
		
		// Ensure that 13 is in the list of primes:
		assertTrue(actual);
	}

}
