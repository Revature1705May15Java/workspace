package com.rev.ex4;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void test() {
		int actual = Factorial.factorial(5);
		int expected = 120;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		int actual = Factorial.factorial(3);
		int expected = 6;
		
		assertEquals(expected, actual);
	}

}
