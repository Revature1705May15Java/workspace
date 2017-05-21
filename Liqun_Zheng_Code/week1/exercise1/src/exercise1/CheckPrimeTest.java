package exercise1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckPrimeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("in setUp()");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("in tearDown()");
	}
	
	@Test
	public void test() {
		
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(5);
		input.add(54);
		input.add(33);
		input.add(77);
		input.add(97);
		input.add(56);
		input.add(31);

		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(5);
		expected.add(97);
		expected.add(31);

		ArrayList<Integer> actual = new ArrayList<Integer>();
		actual = CheckPrime.intArrayPrime(input);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	public void test1() {
		
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(5);
		input.add(19);
		input.add(23);
		input.add(30);
		input.add(37);
		input.add(38);
		input.add(89);
		input.add(107);

		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(5);
		expected.add(19);
		expected.add(23);
		expected.add(37);
		expected.add(89);
		expected.add(107);

		ArrayList<Integer> actual = new ArrayList<Integer>();
		actual = CheckPrime.intArrayPrime(input);
		assertEquals(expected.toString(), actual.toString());
	}

}
