package com.rev.q9;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.rev.q8.Palindromes;

public class PrimesTest {

	@Test
	public void test() {
		ArrayList<Integer> actual = Primes.getPrimes(1, 100);
		
		boolean p0 = actual.get(0) == 1;
		boolean p1 = actual.get(1) == 2;
		boolean p2 = actual.get(2) == 3;
		boolean p3 = actual.get(3) == 5;
		boolean pLast = actual.get(actual.size()-1) == 97;
		
		assertTrue(p0 && p1 && p2 && p3 && pLast);
	}

}
