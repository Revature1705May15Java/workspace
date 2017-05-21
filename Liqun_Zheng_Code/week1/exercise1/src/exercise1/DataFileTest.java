package exercise1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataFileTest {

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
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> actual = new ArrayList<String>();
		input.add("Mickey:Mouse:35:Arizona");
		input.add("Hulk:Hogan:50:Virginia");
		input.add("Roger:Rabbit:22:California");
		input.add("Wonder:Woman:18:Montana");
		actual = DataFile.read(input);
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Name: Mickey Mouse");
		expected.add("Age: 35");
		expected.add("State: Arizona State");
		expected.add("Name: Hulk Hogan");
		expected.add("Age: 50");
		expected.add("State: Virginia State");
		expected.add("Name: Roger Rabbit");
		expected.add("Age: 22");
		expected.add("State: California State");
		expected.add("Name: Wonder Woman");
		expected.add("Age: 18");
		expected.add("State: Montana State");
		
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void test1() {
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> actual = new ArrayList<String>();
		input.add("John:Mouse:75:Arizona");
		input.add("iuoui:Hogan:50:Virginia");
		input.add("reter:Rabbit:22:California");
		input.add("tyr:Woman:62:Montana");
		actual = DataFile.read(input);
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Name: John Mouse");
		expected.add("Age: 75");
		expected.add("State: Arizona State");
		expected.add("Name: iuoui Hogan");
		expected.add("Age: 50");
		expected.add("State: Virginia State");
		expected.add("Name: reter Rabbit");
		expected.add("Age: 22");
		expected.add("State: California State");
		expected.add("Name: tyr Woman");
		expected.add("Age: 62");
		expected.add("State: Montana State");
		
		assertEquals(expected, actual);
	
	}

}
