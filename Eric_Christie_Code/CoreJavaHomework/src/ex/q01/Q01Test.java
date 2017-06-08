package ex.q01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class Q01Test {
  
  ArrayList<Integer> nums = new ArrayList<>();
  Random rando = new Random();

  private void randomize(int n) {
    nums.clear();
    for (int i = 0; i < n; i++) {
      nums.add(rando.nextInt());
    }
  }

  @Test
  public void testSort() {
    for (int n = 5; n < 50; n++) {
      randomize(n);
      ArrayList<Integer> result = Q01.sort(nums);
      nums.sort(null);
      assertEquals(result.size(), nums.size());
      for (int i = 0; i < nums.size(); i++) {
        assertEquals(result.get(i), nums.get(i));
      }
    }
  }

}
