package bubbleSort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class bstest {
	
	BubbleSort b;
	int [] a = {1,0,5,6,3,2,3,7,9,8,4};
/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
*/
	@Before
	public void setUp() throws Exception {
		b = new BubbleSort();
		System.out.println("in setUp()");
	}

	@After
	public void tearDown() throws Exception {
		b = null;
		System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		
		int [] input = {1,0,5,6,3,2,3,7,9,8,4};		
		int[] expected = {0,1,2,3,3,4,5,6,7,8,9};
		int[] actual = b.sort(input);
		
		
		for(int b=0;b<a.length;b++){
            System.out.println("Actual:"+actual[b]);
		}
		
		for(int b=0;b<expected.length;b++){
            System.out.println("Expected:"+expected[b]);
		}
		
		assertArrayEquals(expected, actual);
		
		/**
		for(int b=0;b<a.length;b++){
            System.out.println("Sorted:"+actual[b]);
            
        }
		*/
		
		
		//fail("Not yet implemented");
	}

}
