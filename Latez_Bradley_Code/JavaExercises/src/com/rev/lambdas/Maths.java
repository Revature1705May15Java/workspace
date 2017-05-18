package com.rev.lambdas;

interface MathOperation{
	int operation(int a,int b);
}

public class Maths {
	public static void main (String [] args){
		Maths m = new Maths();
		VarArgsOps v = null;
		
		
		MathOperation addition = (int a, int b)->a+b;
		MathOperation subtraction = (int a, int b)->a-b;
		
		MathOperation multi = (int a, int b)->a*b;
		
		MathOperation intdivide = (int a, int b)->a/b;
		
		VarArgsOps multiply = (int[] x)->{
			int product = 1;
			for (int i:x){
				product = product*product;
			}
			return product;
		};
		
		int [] num = {1,2,3,5};
		int sum = m.operate(addition,5,10);
		int dif = m.operate(subtraction, 10, 5);
		int pro = m.operate(multi, 5, 5);
		int quo = m.operate(intdivide, 9, 3);
		//int multipro = v.operation(1,2,3,4);
		
		System.out.println(sum);
		System.out.println(dif);
		System.out.println(quo);
		System.out.println(pro);
		System.out.println(num);
		//System.out.println(multipro);
	
	}
	
	private int operate(MathOperation op, int a, int b){
		return op.operation(a, b);
	}
	
	
	
	interface VarArgsOps{
		int operation(int...args);
	}
	
	
	

}
