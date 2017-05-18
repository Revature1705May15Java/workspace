package com.question.answer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Q9Test {

	Q9 q;
	
	@Before
	public void setUp() throws Exception {
		q = new Q9();
	}

	@After
	public void tearDown() throws Exception {
		q = null;
	}

	@Test
	public void test() {
		int min = 1, max = 100;
		ArrayList<Integer> expected = new ArrayList<Integer>(
				Arrays.asList(new Integer[] {1, 2, 3, 5, 7, 11, 13,
						17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
						61, 67, 71, 73, 79, 83, 89, 97}));
		ArrayList<Integer> actual = q.getPrimes(min, max);
//		System.out.println(actual);
		assertEquals(expected, actual);
	}

}
