/*
 * Q15. Write a program that defines an interface having the following 
 *      methods: addition, subtraction, multiplication, and division.
 *      Create a class that implements this interface and provides appropriate
 *      functionality to carry out the required operations. Hard code two
 *      operands in a test class having a main method that calls the implementing class.
 */
public interface Calc {
	public double addition(double num, double num2);
	public double subtraction(double num, double num2);
	public double multiplication(double num, double num2);
	public double division(double num, double num2);
}
