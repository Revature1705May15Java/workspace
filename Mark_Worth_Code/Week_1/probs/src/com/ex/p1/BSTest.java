package com.ex.p1;

import static org.junit.Assert.*;

import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;

public class BSTest {
	BubbleSort b;
	static BubbleSort sb;
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		System.out.println("in setUpBeforeClass()");
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		System.out.println("in tearDownAfterClass()");
//	}

	@Before
	public void setUp() throws Exception {
		b=new BubbleSort();
		System.out.println("in set up()");
	}

	@After
	public void tearDown() throws Exception {
		b=null;
		System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		//test case 1 for bubble sort
		int[] inputBS1={1,0,5,6,3,2,3,7,9,8,4};
		int[] expectedBS1={0,1,2,3,3,4,5,6,7,8,9};
		int[] actualBS1=b.bubbleSort(inputBS1);
		assertArrayEquals(expectedBS1,actualBS1);
		//test case 2 for bubble sort
		int[] inputBS2={2,3,6,2,1,1,2,4,5};
		int[] expectedBS2={1,1,2,2,3,4,5,6};
		int[] actualBS2=b.bubbleSort(inputBS2);
		assertArrayEquals(expectedBS2,actualBS2);	
		
	}

}
