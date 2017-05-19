package com.rev.p8;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PaliTest 
{
	
	Palindromes p;

	@Before
	public void setUp() throws Exception 
	{
		p = new Palindromes();
	}

	@After
	public void tearDown() throws Exception 
	{
		p = null;
	}

	@Test
	public void test()
	{
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = new ArrayList<String>();
		
		input.add("karan");
		input.add("madam");
		input.add("tom");
		input.add("civic");
		input.add("radar");
		input.add("sexes");
		input.add("jimmy");
		input.add("kayak");
		input.add("john");
		input.add("refer");
		input.add("billy");
		input.add("did");
		
		expected.add("madam");
		expected.add("civic");
		expected.add("radar");
		expected.add("sexes");
		expected.add("kayak");
		expected.add("refer");
		expected.add("did");
		
		actual = p.findPali(input);
		
		assertEquals(expected,actual);
	}

}
