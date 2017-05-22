package com.ex.p18;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WarholTest 
{
	Warhol w; 
	@Before
	public void setUp() throws Exception 
	{
		w = new Warhol(); 
	}

	@After
	public void tearDown() throws Exception 
	{
		w = null; 
	}

	@Test
	public void test() 
	{
		String s = "CamelCase"; 
		String expected = "camelcase"; 
		String results = w.makeLowercase(s); 
		
		assertTrue(expected.equals(results));
	}
	
	@Test
	public void test2()
	{
		String s = "CamelCase"; 
		boolean expected = true;  
		boolean results = w.hasUppercase(s); 
		
		assertTrue(expected == results);
	}
	
	@Test
	public void test3()
	{
		String s = "656"; 
		int expected = 666;
		int results = w.doMaths(s); 
		
		assertTrue(expected == results); 
	}
	
}

