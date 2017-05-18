package week1.assignment1.q3;

/*
 * Compute N factorial
 */
public class Factorial {
	public static void main(String[] args) {
		System.out.println(fact(0));
	}
	
	public static long fact(int n) {
		if (n == 1 || n == 0)
			return 1;
		else
			return n * fact(n - 1);
	}
}
