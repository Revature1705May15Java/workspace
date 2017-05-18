package fibonacci;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FTest {
	fibonacci f;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		f = new fibonacci();
	
	}

	@After
	public void tearDown() throws Exception {
		f=null;
	}

	@Test
	public void test() {
		
		System.out.println(f.fibo(10));
		int t = f.fibo(10);
		
		
		for(int x=t; x>0;x++)
		{
			System.out.println(f.fibo(x));
		}
		fail("Not yet implemented");
	}

}
