package ex.q12;

public class Q12 {
  public static void main(String[] args) {
    int[] nums = new int[100];
    for (int i = 1; i <= 100; i++) {
      nums[i - 1] = i;
    }
    for (int num: nums) {
      if (num % 2 == 0) {
        System.out.println(num);
      }
    }
  }
}
