package com.rev.q19;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ArrSummationsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<Integer> input = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			input.add(i);
		}
		
		int expectedEvenSum = 30;
		int expectedOddSum = 25;
		
		ArrayList<Integer> expectedNoPrimes = new ArrayList<>();
		expectedNoPrimes.add(4);
		expectedNoPrimes.add(6);
		expectedNoPrimes.add(8);
		expectedNoPrimes.add(9);
		expectedNoPrimes.add(10);
		
		int actualEvenSum = ArrSummations.addEvens(input);
		int actualOddSum = ArrSummations.addOdds(input);
		ArrayList<Integer> actualNoPrimes = ArrSummations.removePrimes(input);
		
		assertEquals(expectedEvenSum, actualEvenSum);
		assertEquals(expectedOddSum, actualOddSum);
		assertTrue(arrayListEquals(expectedNoPrimes, actualNoPrimes));
	}

	static boolean arrayListEquals(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		boolean result = true;
		
		if (arr1.size() != arr2.size()) return false;
		
		for (int i = 0; i < arr1.size(); i++) {
			if (!arr1.get(i).equals(arr2.get(i))) {
				result = false;
				break;
			}
		}
		
		return result;
	}
}
