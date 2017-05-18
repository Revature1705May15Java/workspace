package com.rev.lambdas;

public class Maths
{
 public static void main(String[] args)
 {
		Maths m = new Maths();
		
		MathOperation addition = ((int a, int b )-> a+b);
		MathOperation subtraction = ((int a, int b )-> a-b);
		
		VarArgOps multiply = (int[] x) ->
		{
			int product = 1;
			
			for(int i:x)
			{
				product = product*i;
			}
			return product;
		};
		
		int sum = m.operate(addition,5,10);
		int product = m.opp(multiply, 1,2,3,4,5);
		System.out.println(sum);
		System.out.println(product);
		
		
 }
	private int operate(MathOperation op,int a, int b)
	{
		return op.operation(a, b);
	}
	
	private int opp(VarArgOps op, int... ints)
	{
		return op.operation(ints);
	}
 
}

interface MathOperation
{
	int operation(int a, int b);
}

interface VarArgOps
{
	int operation(int... args);
}
