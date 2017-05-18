package com.ex.p2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciTest 
{
	Fibonacci f; 
	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}

	@Before
	public void setUp() throws Exception 
	{
		f = new Fibonacci(); 
	}

	@After
	public void tearDown() throws Exception 
	{
		f = null; 
	}

	@Test
	public void test() 
	{
		int[] output = f.sequence(5); 
		int[] expected = {0,1,1,2,3}; 
		
		assertArrayEquals(output, expected); 
	}
	
	@Test
	public void test2()
	{
		int[] output = f.sequence(10); 
		int[] expected = {0,1,1,2,3,5,8,13,21,34};
	}

}
