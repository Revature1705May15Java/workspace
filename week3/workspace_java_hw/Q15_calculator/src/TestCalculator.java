/*
 * Q15. Write a program that defines an interface having the following 
 *      methods: addition, subtraction, multiplication, and division.
 *      Create a class that implements this interface and provides appropriate
 *      functionality to carry out the required operations. Hard code two
 *      operands in a test class having a main method that calls the implementing class.
 */
public class TestCalculator {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		int num = 5, num2 = 10;
		double test = 5.5, test2 = 7.8;
		
		System.out.println("Int addition: " + calc.addition(num, num2));
		System.out.println("Int multiplication: " + calc.multiplication(num, num2));
		System.out.println("Double multiplication: " + calc.multiplication(test, test2));
		
	}
}
