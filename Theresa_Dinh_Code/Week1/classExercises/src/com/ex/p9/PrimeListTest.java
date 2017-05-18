package com.ex.p9;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		ArrayList<Integer> results = p.findPrimes(list); 
		ArrayList<Integer> expected = null; 
		
		assertTrue(results.equals(expected)); 
		
	}

}
