/*
 * Q10. Find the minimum of two numbers using ternary operators.
 */
public class TernaryOps {
	public static void main(String[] args) {
		int first = 5, second = 7;
		
		int result = first > second ? first : second;
		
		System.out.println("Biggest number is: " + result);
	}
}
