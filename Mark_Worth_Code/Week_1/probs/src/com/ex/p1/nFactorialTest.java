package com.ex.p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class nFactorialTest {
	nFactorial n;
	@Before
	public void setUp() throws Exception {
		n=new nFactorial();
		System.out.println("in setUp()");
	}

	@After
	public void tearDown() throws Exception {
		n=null;
		System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		int inputn1=4;
		int expectedn1=24;
		int actualn1=n.Factorial(inputn1);
		assertEquals(expectedn1,actualn1);
		
		int inputn2=6;
		int expectedn2=720;
		int actualn2=n.Factorial(inputn2);
		assertEquals(expectedn2,actualn2);
		
	}

}
