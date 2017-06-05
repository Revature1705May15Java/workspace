/*
 * Q15. Write a program that defines an interface having the following 
 *      methods: addition, subtraction, multiplication, and division.
 *      Create a class that implements this interface and provides appropriate
 *      functionality to carry out the required operations. Hard code two
 *      operands in a test class having a main method that calls the implementing class.
 */
public class Calculator implements Calc{

	@Override
	public double addition(double num, double num2) {
		double temp = num + num2;
		return temp;
	}

	@Override
	public double subtraction(double num, double num2) {
		double temp = num - num2;
		return temp;
	}

	@Override
	public double multiplication(double num, double num2) {
		double temp = num*num2;
		return temp;
	}

	@Override
	public double division(double num, double num2) {
		double temp = num/num2;
		return temp;
	}

}
