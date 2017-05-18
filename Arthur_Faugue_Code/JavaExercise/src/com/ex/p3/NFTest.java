package com.ex.p3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NFTest {
	
	NFactorial n1;
//
//	@/*BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}*/

	//@Before
	public void setUp() throws Exception {
		n1 = new NFactorial();
		System.out.println("Setting Up");
	}

	@After
	public void tearDown() throws Exception {
		n1 = null;
		System.out.println("Tearing Down");
	}

	@Test
	public void test() {
		
		
	}

}
