package com.rev.q15;

public class Main {
	private static final int X = 200;
	private static final int Y = 100;
	
	public static void main(String[] args) {
		Mathematical<Integer> math = new IntegerOperations();
		System.out.println("Our operands are:");
		System.out.println("X = " + X +", Y = " + Y);
		
		System.out.println("\nX + Y = " + math.addition(X, Y));
		System.out.println("\nX - Y = " + math.subtraction(X, Y));
		System.out.println("\nX * Y = " + math.multiplication(X, Y));
		System.out.println("\nX / Y = " + math.division(X, Y));
	}
}
