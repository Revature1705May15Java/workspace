package com.rev.p9;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrimeNumbersTest {

	PrimeNumbers p;
	
	@Before
	public void setUp() throws Exception 
	{
		p = new PrimeNumbers();
	}

	@After
	public void tearDown() throws Exception 
	{
		p = null;
	}

	@Test
	public void test() 
	{
		ArrayList <Integer> input = new ArrayList <Integer>();
		ArrayList <Integer> expected = new ArrayList <Integer>();
		ArrayList <Integer> actual = new ArrayList <Integer>();
		
		//add numbers
		for(int i = 1;i<=18;i++)
		{
			input.add(i);
		}
		
		expected.add(2);
		expected.add(3);
		expected.add(5);
		expected.add(7);
		expected.add(11);
		expected.add(13);
		expected.add(17);
		
		actual = p.findPrime(input);
		
		assertEquals(expected,actual);
	}

}
