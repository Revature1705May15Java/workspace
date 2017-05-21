package exercise1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InheritTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Inherit heir = new Inherit();
		boolean actual, expected ;
		expected = true;
		actual = heir.isUpperCase("dfwWERdfsdf");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test1() {
		Inherit heir = new Inherit();
		boolean actual, expected ;
		expected = false;
		actual = heir.isUpperCase("werwedsf");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		Inherit heir = new Inherit();
		String actual, expected ;
		expected = "DFWWERDFSDF";
		actual = heir.convertLowerToUpper("dfwWERdfsdf");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		Inherit heir = new Inherit();
		String actual, expected ;
		expected = "DFWWRDFSF";
		actual = heir.convertLowerToUpper("dfwWRdfsf");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		Inherit heir = new Inherit();
		int actual, expected ;
		expected = 4542;
		actual = heir.convertToInt("4532");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		Inherit heir = new Inherit();
		int actual, expected ;
		expected = -4542;
		actual = heir.convertToInt("-4552");
		assertEquals(expected, actual);
	}
	
	
}
