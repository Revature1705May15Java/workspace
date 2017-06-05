import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
		int input = 3, expected = 2;
		int actual = fib.getFibonacci(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		int input = 2, expected = 1;
		int actual = fib.getFibonacci(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		int input = 1, expected = 1;
		int actual = fib.getFibonacci(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		int input = 5, expected = 5;
		int actual = fib.getFibonacci(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		int input = 0, expected = 0;
		int actual = fib.getFibonacci(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {
		int input = 10, expected = 55;
		int actual = fib.getFibonacci(input);
		
		assertEquals(expected, actual);
	}
}