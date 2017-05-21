package com.revature_wk1.palindrome;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest 
{
	static Palindrome paladin = new Palindrome();
	
	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Preparing for testing...");
	}

	@After
	public void tearDown() throws Exception 
	{
		System.out.println("Testing is over.");
	}

	@Test
	public void test() 
	{
		String[] palindromeInput = {"eye", "very", "Disney", "noon", "level"};
		
		String[] expectedPalindrome = {"eye", "yrev", "yensiD", "noon", "level"};
		
		paladin.main(palindromeInput);
	}

}
