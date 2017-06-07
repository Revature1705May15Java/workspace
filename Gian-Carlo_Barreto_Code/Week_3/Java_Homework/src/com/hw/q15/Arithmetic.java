package com.hw.q15;

interface Operators {
	double addition(double a, double b);
	double subtraction(double a, double b);
	double multiplication(double a, double b);
	double division(double a, double b);
}

class OperatorsImpl implements Operators {
	public double addition(double a, double b) {
		return a + b;
	}
	
	public double subtraction(double a, double b) {
		return a - b;
	}
	
	public double multiplication(double a, double b) {
		return a * b;
	}
	
	public double division(double a, double b) {
		return a / b;
	}
}

/**
 * Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface and provides 
 * appropriate functionality to carry out the required operations. 
 * Hard code two operands in a test class having a main method that calls the implementing class.
 * @author Gian-Carlo
 *
 */
public class Arithmetic {

	public static void main(String[] args) {
		OperatorsImpl o = new OperatorsImpl();
		double a = 10.0;
		double b = 5.0;
		System.out.println(o.addition(a, b));
		System.out.println(o.subtraction(a, b));
		System.out.println(o.multiplication(a, b));
		System.out.println(o.division(a, b));
	}

}
