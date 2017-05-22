package com.ex.p9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrimeListTest 
{
	PrimeList p; 
	
	@Before
	public void setUp() throws Exception 
	{
		p = new PrimeList(); 
	}

	@After
	public void tearDown() throws Exception 
	{
		p = null; 
	}

	@Test
	public void test() 
	{
		
		ArrayList<Integer> list = new ArrayList<Integer> (); 
		for(int i = 1; i <= 100; i++)
		{
			list.add(i); 
		}
//		System.out.println(list.toString());
		List<Integer> results = p.findPrimes(list); 
//		System.out.println(p.findPrimes(list).toString()); 
//		System.out.println(p.findPrimes(list));
		List<Integer> expected = new ArrayList<Integer>(); 
		expected.addAll(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97)); 
		
//		System.out.println(expected.toString());
		assertEquals(results, expected); 
		
	}

}
