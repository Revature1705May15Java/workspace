package com.revature.factorial;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class nFactorialTest 
{
	static nFactorial nFactorialTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		//nFactorialTest = new nFactorial();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		//nFactorialTest = null;
	}

	@Before
	public void setUp() throws Exception 
	{
		nFactorialTest = new nFactorial();
		System.out.println("Setting up test...");
	}

	@After
	public void tearDown() throws Exception 
	{
		nFactorialTest = null;
		System.out.println("Tearing down test...");
	}

	@Test
	public void test() 
	{
		//Scanner scanTest = new Scanner(System.in);
		int testFact = 10;
		
		int expectFact = 3_628_800;
		
		int actualFact = nFactorialTest.Factorial(testFact);
		System.out.println(actualFact);
		
		assertEquals(expectFact, actualFact);
	}

}
