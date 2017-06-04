package ex.q19;

import java.util.ArrayList;

public class Q19 {

  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>();
    ArrayList<Integer> primes = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      nums.add(i);
      if (i != 1) {
        boolean isPrime = true;
        for (Integer p : primes) {
          if (i % p == 0) {
            isPrime = false;
          }
        }
        if (isPrime) {
          primes.add(i);
        }
      }
    }
    System.out.println(nums);
    int evenSum = 0;
    int oddSum = 0;
    for (Integer num : nums) {
      if (num % 2 == 0) {
        evenSum += num;
      } else {
        oddSum += num;
      }
    }
    System.out.println("Sum of evens: " + evenSum + ", Sum of odds: " + oddSum);
    nums.removeAll(primes);
    System.out.println(nums);
  }

}
