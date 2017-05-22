package com.ex.p19;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListTest 
{
	ListFun l; 
	
	@Before
	public void setUp() throws Exception 
	{
		l = new ListFun(); 
	}

	@After
	public void tearDown() throws Exception 
	{
		l = null; 
	}

	@Test
	//will test addEvens method
	public void test() 
	{
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		for(int i = 1; i <= 10; i++)
			list.add(i); 
		
		int expected = 30; 
		int results = l.addEvens(list); 
		
		assertTrue(expected == results); 
	}
	
	@Test
	//test removePrimes method	
	public void test2()
	{
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		for(int i = 1; i <= 10; i++)
			list.add(i); 
		
		ArrayList<Integer> expected = new ArrayList<Integer>(); 
		expected.addAll(Arrays.asList(1, 4, 6, 8, 10)); 
		
		ArrayList<Integer> results = l.removePrimes(list); 
		assertTrue(results.containsAll(expected) && expected.containsAll(results)); 
	}

	@Test
	public void test3()
	{
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		for(int i = 1; i <= 10; i++)
			list.add(i); 
		
		int expected = 25; 
		int results = l.addOdds(list);
		
		assertTrue(expected == results); 
	}
}
