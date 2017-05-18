package q2q;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {
	Fibonacci fib;
	@Before
	public void setUp() throws Exception {
		fib = new Fibonacci();
	}

	@After
	public void tearDown() throws Exception {
		fib = null;
	}

	@Test
	public void test() {
		int input1 = 0, input2 = 1, input3= 7;
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 2, 3, 5, 8));
		ArrayList<Integer> actual = fib.fibonacci(input1, input2, input3);
		assertEquals(expected,actual);
	}

	@Test
	public void test2() {
		int input1 = 0, input2 = 1, input3= 1;
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(0));
		ArrayList<Integer> actual = fib.fibonacci(input1, input2, input3);
		assertEquals(expected,actual);
	}

}
