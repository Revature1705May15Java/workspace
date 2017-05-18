package com.ex.p3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactorialTest 
{
	
	Factorial f; 

	@Before
	public void setUp() throws Exception 
	{
		f = new Factorial(); 
	}

	@After
	public void tearDown() throws Exception 
	{
		f = null; 
	}

	@Test
	public void test() 
	{
		int output = f.doThing(5); 
		int expected = 120; 
		
		assertEquals(output, expected); 
	}
	
	@Test
	public void test2()
	{
		int output = f.doThing(10); 
		int expected = 3628800; 
		
		assertEquals(output, expected); 
	}

}
