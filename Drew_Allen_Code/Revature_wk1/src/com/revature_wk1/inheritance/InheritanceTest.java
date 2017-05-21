package com.revature_wk1.inheritance;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InheritanceTest 
{

	Inherit inherit;
	
	@Before
	public void setUp() throws Exception 
	{
		inherit = new Inherit();
		System.out.println("Inheritance Test is ready!");
	}

	@After
	public void tearDown() throws Exception 
	{
		inherit = null;
		System.out.println("Inheritance Test is finished.");
	}

	@Test
	public void test() 
	{
		String arthur = "Arthur";
		
		equals(inherit.convertLowerToUpper(arthur));
	}
	
	@Test
	public void testNumbers()
	{
		String numbers = "9837849";
		
		equals(inherit.convertToInt((numbers)));
	}
	
	@Test
	public void testUpperCase()
	{
		String upper = "bir";
		
		assertFalse(inherit.isUpperCase(upper));
	}
	
	@Test
	public void testNull()
	{
		String nothing = null;
		
		assertTrue(inherit.isUpperCase(null));
	}

}
