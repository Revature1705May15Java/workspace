package factorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class factorialTest {

	factorial fact;
	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}

	@Before
	public void setUp() throws Exception {
		fact = new factorial();
	}

	@After
	public void tearDown() throws Exception {
		fact = null;
	}

	@Test
	public void test() {
		int input = 0, expected = 1;
		int actual = fact.getFactorial(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		int input = 1, expected = 1;
		int actual = fact.getFactorial(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		int input = 3, expected = 6;
		int actual = fact.getFactorial(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		int input = 6, expected = 720;
		int actual = fact.getFactorial(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		int input = 8, expected = 40320;
		int actual = fact.getFactorial(input);
		
		assertEquals(expected, actual);
	}

	
	
	
	
	

}
