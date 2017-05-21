package com.revature_wk1.prime;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrimeNumbersTest 
{
	static PrimeNumbers pn = new PrimeNumbers();

	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Setting up Test...");
	}

	@After
	public void tearDown() throws Exception 
	{
		pn = null;
		System.out.println("Testing Over.");
	}

	@Test
	public void test() 
	{
		String[] testPrime = {"35"};
		
		pn.main(testPrime);
	}
	
	@Test
	public void testChar()
	{
		String[] testPrime = {"/"};
		
		pn.main(testPrime);
	}

}
