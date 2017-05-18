package week1.assignment1.q1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest {
	BubbleSort b;

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
		// Input array
		int[] input = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		// Expected sorted array
		int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		
		// Actual array that the bubblesort() method returns
		int[] actual = b.bubblesort(input);
		
		// Checks if the expected and actual arrays are equal.
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		// Input array
		int[] input = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		// Actual array that the bubblesort() method returns
		int[] actual = b.bubblesort(input);
		
		boolean n = actual == null;
		
		assertFalse(n);
	}
}
