package com.rev.lamda;

public class Maths {
	
	public static void main(String[] args) {
		Maths m = new Maths();
		
		MathOp addition = (int a, int b) -> a+b;
		MathOp subtraction = (int a, int b) -> a-b;
		MathOp multiply = (int a, int b) -> a*b;
		
		int sum = m.operate(addition, 5, 10);
		System.out.println(sum);
		sum = m.operate(subtraction, 5, 2);
		System.out.println(sum);
		sum = m.operate(multiply, 5, 5);
		System.out.println(sum);
		
		/*
		 * 3 user defined math functions  
		 * numberedSquared returns the square root of an number
		 * numberedCubed  returns the value of the numbered cubed
		 * hypotenuse returns the size of the hypotenuse of a triange
		 * 		given the size of its other 2 sides
		 */
		Function1 numberedSquared = (long a) -> a*a;
		Function1 numberedCubed = (long a) -> a*a*a;
		Function2 hypotenuse = (long a, long b) ->(long) Math.sqrt(((a*a)+(b*b)));
		
		long check = 10, check2 = 5;
		long sum1 = m.operate(numberedSquared, check);
		System.out.println(sum1);
		sum1 = m.operate(numberedCubed, check);
		System.out.println(sum1);
		sum1 = m.operate(hypotenuse, check, check2);
		System.out.println(sum1);
		
	}
	
	private int operate(MathOp op, int a, int b){
		return op.operation(a, b);
	}
	private long operate(Function1 op1, long a){
		return op1.operate(a);
	}
	private long operate(Function2 op1, long a, long b){
		return op1.operate(a, b);
	}
}
interface MathOp {
	int operation(int a, int b);
}

interface VarArgsOps{
	int operation(int...args);
}

interface Function1{
	long operate(long a);
}

interface Function2{
	long operate(long a, long b);
}