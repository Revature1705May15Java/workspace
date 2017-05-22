package com.ex.p8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest 
{
	Palindrome p;
	
	@Before
	public void setUp() throws Exception 
	{
		p = new Palindrome(); 
	}

	@After
	public void tearDown() throws Exception 
	{
		p = null; 
	}

	@Test
	public void test() 
	{
		String[] words = {"karan", "madam", "billy", "tom", "civic", 
				"radar", "sexes", "jimmy", "kayak", "john", "refer", "did"}; 
		
		ArrayList<String> results = p.palinCheck(words);; 
		ArrayList<String> expected= new ArrayList<String> (); 
		expected.addAll(Arrays.asList("madam","civic","radar","sexes","kayak","refer","did"));

		assertTrue(results.containsAll(expected) && expected.containsAll(results)); 
	}

}
