package com.hw.interface_ex;

public class Main {
	public static void main(String[] args) {
		InterfaceEx ie = new InterfaceEx();
		int num1 = 10;
		int num2 = 2;
		System.out.println(num1 + " + " + num2 + " = "  + ie.addition(num1, num2));
		System.out.println(num1 + " - " + num2 + " = "  +ie.subtraction(num1, num2));
		System.out.println(num1 + " * " + num2 + " = "  +ie.multiplication(num1, num2));
		System.out.println(num1 + " / " + num2 + " = "  +ie.division(num1, num2));
	}
}
