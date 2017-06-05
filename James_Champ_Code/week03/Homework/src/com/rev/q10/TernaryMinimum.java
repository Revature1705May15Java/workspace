package com.rev.q10;

public class TernaryMinimum {
	private static final int NUM_1 = 56789;
	private static final int NUM_2 = 38383;
	
	public static void main(String[] args) {
		System.out.println(min(NUM_1, NUM_2));
	}
	
	private static int min(int x, int y) {
		return (x < y) ? x : y;
	}
}
