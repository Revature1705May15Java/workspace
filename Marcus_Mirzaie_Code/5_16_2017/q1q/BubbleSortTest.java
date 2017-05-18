package q1q;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest {
	BubbleSort b;
	
	@BeforeClass
	public static void setUpBeforeCalss() throws Exception{
		System.out.println("in setUpBeforeClass");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println("in tearDownAfterClass");
	}
	
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
		int[] iarray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		
		int[] actual = b.sort(iarray);
		
		assertArrayEquals(expected, actual);

	}

	@Test
	public void test2() {
		int[] iarray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		int[] actual = b.sort(iarray);
		
		boolean n = actual == null;
		
		assertFalse(n);

	}

}
