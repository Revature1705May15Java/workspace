package bubbleSort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class bubbleSortTest {

	bubbleSort bs;
	static bubbleSort sb;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sb = new bubbleSort();
		System.out.println("In setUpBeforeClass!");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sb = null;
		System.out.println("In tearDownAfterClass!");
	}

	@Before
	public void setUp() throws Exception {
		bs = new bubbleSort(); // refreshing your object between each test.
		System.out.println("In setup.");
	}

	@After
	public void tearDown() throws Exception {
		bs = null; // clears object for next test.
		System.out.println("In teardown.");
	}

	@Test
	public void test() {
		int[] input = {1,0,5,2,3,3,4,6,7,8,9}, expected = {0,1,2,3,3,4,5,6,7,8,9};
		int[] actual = bs.sort(input);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		int[] input = {-1,0,7,31,55,2,3,3,4,6,7,8,9}, expected = {-1,0,2,3,3,4,6,7,8,9,31,55};
		int[] actual = bs.sort(input);
		
		boolean n = (actual == null);
		
		assertFalse(n);
	}
	
	@Test
	public void test3() {
		int[] input = {1,0,5,2,3,3,4,6,7,8,9};
		int[] actual = bs.sort(input);
		
		boolean n = (actual == null);
		
		assertFalse(n);
	}
	

}
