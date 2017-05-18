package com.ex.p2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibTest {
	Fibonacci f1;
	@Before
	public void setUp() throws Exception {
		f1 = new Fibonacci();
		System.out.println("Setting Up");
	}

	@After
	public void tearDown() throws Exception {
		f1 = null;
		System.out.println("Tearing Down");
	}

	@Test
	public void test() {
		
	}

}
