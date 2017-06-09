package com.rev.ex9;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetNumbersTest {
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
		ArrayList<Integer> list = pn.getNumbers();
		
		int expected = 100;
		int actual = list.size();
		
		// Ensure list has 100 elements
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		ArrayList<Integer> list = pn.getNumbers();
		
		int expected = 100;
		int actual = list.get(list.size() - 1);
		
		// Ensure last item in list is 100
		assertEquals(expected, actual);
	}

}
