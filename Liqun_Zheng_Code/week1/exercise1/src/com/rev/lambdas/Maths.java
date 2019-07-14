package com.rev.lambdas;

public class Maths {
	public static void main(String[] args) {
		Maths m = new Maths();
		
		MathOperation addition = (int a, int b)-> a+ b;
		MathOperation subtraction = ( int a, int b)-> a-b;
		StringOperation findSub = (String a, int b, int c)-> a.substring(b,c);
		StringAddition strAdd = (String a, String b) -> a.concat(b);
		int sum = m.operate(addition, 5, 10); 
		System.out.println(sum);
		
		String sub = m.stringHand(findSub, "sldfkjsdld", 2, 5);
		System.out.println(sub);
		
		String strA = m.stringAdd(strAdd, "sldfkjsdld", "dfd");
		System.out.println(strA);
	}
	private int operate(MathOperation op, int a, int b){
		return op.operation(a, b);
	}
	private String stringHand(StringOperation op, String str, int a, int b){
		return op.operation(str, a, b);
	}
	private String stringAdd(StringAddition op, String a, String b){
		return op.operation(a, b);
	}
}

interface MathOperation{
	int operation( int a, int b);
}

interface VarArgsOps{
	int operation(Integer... args);
}
interface StringAddition{
	String operation(String a, String b);
}

interface StringOperation{
	String operation(String a, int b, int c);
}