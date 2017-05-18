package com.rev.lambdas;

public class Maths {
	
	
	public static void main(String[] args) {
		Maths m = new Maths();
		
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (int a, int b) -> a - b;
		
		System.out.println(addition.operation(20, 60));
		
		int sum = m.operate(addition, 5, 10);
		System.out.println(sum);
		
		VarArgsOps multiply = (int[] nums) -> {
			int product = 1;
			
			for (int i : nums) {
				product *= i;
			}
			
			return product;
		};
		
		int prod = m.operate(multiply, 4, 3, 2);
		System.out.println(prod);
	}
	
	private int operate(MathOperation op, int a, int b) {
		return op.operation(a,  b);
	}
	
	private int operate(VarArgsOps op, int...ints) {
		return op.operation(ints);
	}
	
}

interface MathOperation {
	int operation(int a, int b);
}

interface VarArgsOps {
	int operation(int...args);
}
