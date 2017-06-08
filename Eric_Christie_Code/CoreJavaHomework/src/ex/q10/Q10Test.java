package ex.q10;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class Q10Test {

  Random rando = new Random();

  @Test
  public void testGetMinimum() {
    for (int i = 0; i < 1000; i++) {
      int a = rando.nextInt();
      int b = rando.nextInt();
      assertEquals(Q10.getMinimum(a, b), Math.min(a, b));
    }
  }

}
