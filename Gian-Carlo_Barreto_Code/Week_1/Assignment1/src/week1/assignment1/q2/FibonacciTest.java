package week1.assignment1.q2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {
	Fibonacci f;
	
	@Before
	public void setUp() throws Exception {
		f = new Fibonacci();
		System.out.println("in setUp()");
	}

	@After
	public void tearDown() throws Exception {
		f = null;
		System.out.println("in tearDown()");
	}

	@Test
	public void test() {
		// Number of fibonacci numbers
		int num = 5;
		
		// Expected fibonacci sequence
		int[] expected = {0, 1, 1, 2, 3};
		
		// Actual fib sequence computed
		int[] actual = f.fibSequence(num);
		
		// Check to see if expected and atual arrays are equal
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		// Number of fibonacci numbers
		int num = 25;
		
		// Expected fibonacci sequence
		int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		
		// Actual fib sequence computed
		int[] actual = f.fibSequence(num);
		
		// Check to see if expected and atual arrays are equal
		assertArrayEquals(expected, actual);
	}
}
