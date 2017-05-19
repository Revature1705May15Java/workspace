package com.rev.p2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class fibonacciTest 
{

	fibonacci f;
//	static fibonacci fs;
	
/*	public static void setUpBeforeClass() throws Exception
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}
*/
	@Before
	public void setUp() throws Exception 
	{
		f = new fibonacci();
	}

	@After
	public void tearDown() throws Exception 
	{
		f = null;
	}

	@Test
	public void test() 
	{
		int [] expected = {0,1,1,2,3};
		int [] actual = f.sequence(5);
		
		assertArrayEquals(expected, actual);
		
	}

}
