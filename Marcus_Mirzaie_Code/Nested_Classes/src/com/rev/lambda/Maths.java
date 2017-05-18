package com.rev.lambda;

public class Maths {

	MathOperation addition = (int a, int b)-> a+b;
	MathOperation subtractions = (int a, int b)-> a-b;
	MathOperation multiply = (int a, int b)-> a*b;
	MathOperation divide = (int a, int b)-> a/b;
	
	public static void main(String[] args) {

		Maths m = new Maths();
		
		MathOperation addition = (int a, int b)-> a+b;
		MathOperation subtractions = (int a, int b)-> a-b;
		MathOperation multiply = (int a, int b)-> a*b;
		MathOperation divide = (int a, int b)-> a/b;
		
		int sum = m.operate(addition, 5, 10);
		System.out.println(sum);
		
	}
	
	private int operate(MathOperation op, int a, int b){
		return op.operation(a, b);
	}
}

interface MathOperation{
	int operation(int a, int b);
}