/*
 * Q6. Write a program to determine if an integer is even without
 *     using the modulus operator (%)
 */
public class IsEven {
	public static void main(String[] args) {
		int value = 87;
		double test = value;
		if((test/2) == Math.floor(test/2)) System.out.println("Value: " + value + " is even!");
		else System.out.println("Value: " + value + " is odd! :c");
		
	}
}