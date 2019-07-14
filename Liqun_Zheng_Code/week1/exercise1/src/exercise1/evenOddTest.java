package exercise1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class evenOddTest {

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
		for(int i=0; i < 11; i++){
			input.add(i);
		}
		
		int expected = 30;
		int actual = evenOdd.evenSum(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test1() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i=0; i < 11; i++){
			input.add(i);
		}
		
		int expected = 25;
		int actual = evenOdd.oddSum(input);
		assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i=11; i < 23; i++){
			input.add(i);
		}
		
		int expected = 102;
		int actual = evenOdd.evenSum(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i=11; i < 23; i++){
			input.add(i);
		}
		
		int expected = 96;
		int actual = evenOdd.oddSum(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void tes5() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i=0; i < 11; i++){
			input.add(i);
		}
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(4);
		expected.add(6);
		expected.add(8);
		expected.add(9);
		expected.add(10);
		ArrayList<Integer> actual = new ArrayList<Integer>();
		
		actual = evenOdd.notPrimeArray(input);
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void tes6() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i=11; i < 23; i++){
			input.add(i);
		}
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(12);
		expected.add(14);
		expected.add(15);
		expected.add(16);
		expected.add(18);
		expected.add(20);
		expected.add(21);
		expected.add(22);
		ArrayList<Integer> actual = new ArrayList<Integer>();
		
		actual = evenOdd.notPrimeArray(input);
		assertEquals(expected, actual);
	
	}
	
}
