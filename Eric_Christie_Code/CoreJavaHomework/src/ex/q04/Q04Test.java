package ex.q04;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q04Test {

  int[] factorials = {0,1,2,6,24,120,720,5040,40320,362880,3628800,39916800,479001600};

  @Test
  public void testFactorial() {
    for (int i = 0; i < factorials.length; i++) {
      assertEquals(Q04.factorial(i), factorials[i]);
    }
  }

}
