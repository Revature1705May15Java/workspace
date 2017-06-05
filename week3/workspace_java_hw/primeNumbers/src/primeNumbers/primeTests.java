package primeNumbers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class primeTests {
	static primeNumbers prime;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		prime = new primeNumbers();
	}

	@After
	public void tearDown() throws Exception {
		prime = null;
	}
	
	@Test
	public void test() { // 
		prime.setListSize(1);
		ArrayList<Integer> actual = prime.run();
		assertEquals(actual.isEmpty(), true);
	}
	
	@Test
	public void test2() {
		prime.setListSize(30);
		ArrayList<Integer> actual = prime.run();
		ArrayList<Integer> expected = new ArrayList<Integer>(){{
			add(2); add(3); add(5); add(7); add(11); add(13); add(17); 
			add(19); add(23); add(29);}};
			
		assertEquals(actual, expected);
	}
}