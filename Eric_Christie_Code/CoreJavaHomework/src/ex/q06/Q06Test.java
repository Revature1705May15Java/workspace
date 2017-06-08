package ex.q06;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class Q06Test {
  
  Random rando = new Random();

  @Test
  public void testIsEven() {
    for (int i = 0; i < 100; i++) {
      assertEquals(Q06.isEven(i), (i % 2 == 0));
    }
  }

}
