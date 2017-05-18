package com.ex.lambdas;

import javax.print.DocFlavor.INPUT_STREAM;

public class Maths {
	
	public static void main(String[] args) {
		Maths m = new Maths();
		
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (int a, int b) -> a - b;
		
		int sum = m.mathOperator(addition, 5, 10);
		System.out.println("Sum = " + sum);
		
		
		
		VarArgsOps multiply = (int[] x) -> { // taking in an array of ints and returning the product.
			int product = 1;
			for(int i:x) product *= i;
			
			return product;
		};
		int[] nums = {1,2,3,4};
		
		int product = m.varOperator(multiply, nums);
		System.out.println("Product: " + product);
	}
	
	
	private int mathOperator(MathOperation up, int a, int b){
		return up.operation(a, b);
	};
	
	private int varOperator(VarArgsOps up, int... a){
		return up.operation(a);
	};
	
	
}

interface MathOperation{
	int operation(int a, int b);
}

interface VarArgsOps{ // variable amount of args
	int operation(int... args);
}
