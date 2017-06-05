package palindromes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class palindromesTest {
	palindromes rev;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		rev = new palindromes();
	}

	@After
	public void tearDown() throws Exception {
		rev = null;
	}

	@Test
	public void test() {

		ArrayList<String> words = new ArrayList<String>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		ArrayList<String> actual = rev.getPalindromes(words);

		ArrayList<String> expected = new ArrayList<String>();
		expected.add("madam");
		expected.add("civic");
		expected.add("radar");
		expected.add("sexes");
		expected.add("kayak");
		expected.add("refer");
		expected.add("did");
		
		assertEquals(actual, expected);
		
	}

}
