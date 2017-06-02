package com.ex.p20;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataFileTest {
	DataFile d1;

	/*
	 * Confirms the instance of the DataFile is set up
	 */
	@Before
	public void setUp() throws Exception {
		d1 = new DataFile();
		System.out.println("Setting up");
	}

	/*
	 * Confirms the instance of the DataFile is set to null
	 */
	@After
	public void tearDown() throws Exception {
		d1 = null;
		System.out.println("Trearing down");
	}

	/*
	 * Checks if the given string will print out the correct information
	 * to the console.
	 */
	@Test
	public void checkString() {
		
		String[] actual = {"Mickey", "Mouse", "35", "Arizona"};
		String expect = "Name: Mickey Mouse\nAge: 35\nState: Arizona State";
		
		String actual1 = d1.printLine(actual);
		
		assertEquals(expect, actual1);
	}

}
