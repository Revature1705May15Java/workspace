package com.hw.fibonacci;

public class Fibonacci {
	public static void main(String[] args) {
		int firstNumber = 1;
		int secondNumber = 1;
		int iNumber = 1;
		System.out.print(firstNumber + " " + secondNumber + " ");
		for(int i = 3; i <= 25; i++) {
			iNumber = firstNumber + secondNumber;
			System.out.print(iNumber + " ");
			firstNumber = secondNumber;
			secondNumber = iNumber;
		}
	}
}
