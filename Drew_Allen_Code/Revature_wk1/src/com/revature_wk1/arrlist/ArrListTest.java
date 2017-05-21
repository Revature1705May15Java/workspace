package com.revature_wk1.arrlist;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrListTest 
{
	static ArrList aL = new ArrList();

	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Array List is ready for testing.");
	}

	@After
	public void tearDown() throws Exception 
	{
		aL = null;
		System.out.println("Array List is done testing.");
	}

	@Test
	public void testEven() 
	{
		String [] even = {"40"};
		
		aL.main(even);
	}
	
	@Test
	public void testOdd()
	{
		String [] odd = {"21"};
		
		aL.main(odd);
	}

}
