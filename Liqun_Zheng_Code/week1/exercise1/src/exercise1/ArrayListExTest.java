package exercise1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListExTest {
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
		
		ArrayList<String> input = new ArrayList<String>();
		input.add("karan");
		input.add("madam");
		input.add("tom");
		input.add("civic");
		input.add("radar");
		input.add("sexes");
		input.add("jimmy");
		input.add("kayak");
		input.add("john");
		input.add("refer");
		input.add("billy");
		input.add("did");
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("madam");
		expected.add("civic");
		expected.add("radar");
		expected.add("sexes");
		expected.add("kayak");
		expected.add("refer");
		expected.add("did");
		
		ArrayList<String> actual = new ArrayList<String>();
		actual = ArrayListEx.returnArrayList(input);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	public void test1() {
		
		ArrayList<String> input = new ArrayList<String>();
		input.add("ghf");
		input.add("edde");
		input.add("tyuyt");
		input.add("vcbcvb");
		input.add("idxdi");
		input.add("wokow");
		input.add("fghfg");
		input.add("werwe");
		input.add("hjevejh");
		input.add("reref");
		input.add("tyuyt");
		input.add("pkwe");
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("edde");
		expected.add("tyuyt");
		expected.add("idxdi");
		expected.add("wokow");
		expected.add("hjevejh");
		expected.add("tyuyt");

		ArrayList<String> actual = new ArrayList<String>();
		actual = ArrayListEx.returnArrayList(input);
		assertEquals(expected.toString(), actual.toString());
	}

}
