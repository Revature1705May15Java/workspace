package week1.assignment1.q2;

/*
 * Displays first 25 Fibonacci numbers beginning at 0.
 */
public class Fibonacci {
	public static void main(String[] args) {
		int[] nums = fibSequence(25);
		for (int n : nums)
			System.out.print(n + " ");
	}
	
	public static int[] fibSequence(int numOfElements) {
		int[] nums = new int[numOfElements];
		
		for (int i = 0; i < numOfElements; i++) {
			nums[i] = fib(i);
		}
		
		return nums;
	}
	
	public static int fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n-1) + fib(n-2);
	}
}