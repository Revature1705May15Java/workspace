package com.ex.p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BSTest {
	
	BubbleSort b1;
	
	/*@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}*/

	@Before
	public void setUp() throws Exception {
		b1 = new BubbleSort();
		System.out.println("Setting up");
	}

	@After
	public void tearDown() throws Exception {
		b1 = null;
		System.out.println("Tearing Down");
	}

	@Test
	public void test() {
		
		int[] Array = {1,0,5,6,3,2,3,7,9,8,4};
		
		int[] ArrayExpect = {0,1,2,3,3,4,5,6,7,8,9};
		
		int[] ArrayActual = b1.BubbleSortThis(Array);
		assertArrayEquals(ArrayExpect, ArrayActual);
	}

}
