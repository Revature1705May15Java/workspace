package com.rev.q13;

public class PrintTriangle {
	public static void main(String[] args) {
		int count = 0;
		
		for(int row = 1; row <= 4; row++) {
			for(int amount = row; amount > 0; amount--) {
				System.out.print((count++ % 2) + " ");
			}
			System.out.println();
		}
	}
}
