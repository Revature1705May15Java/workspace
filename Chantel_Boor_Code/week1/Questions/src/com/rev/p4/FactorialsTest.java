package com.rev.p4;


import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactorialsTest {

	static Factorials fs;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		fs = new Factorials ();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		fs = null;
	}

	@Test
	public void test() 
	{
		int input = 5;
		int expected = 120;
		int actual = fs.CalcF(input);
		
		assertEquals(expected,actual);
	}

}
