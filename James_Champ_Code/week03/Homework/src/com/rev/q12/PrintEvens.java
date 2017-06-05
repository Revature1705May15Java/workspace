package com.rev.q12;

public class PrintEvens {
	public static void main(String[] args) {
		int[] numberArray = new int[100];
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = i + 1;
		}
		
		System.out.println("Evens");
		for(int i : numberArray) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
