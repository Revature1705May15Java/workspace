package com.hw.interface_ex;

public class InterfaceEx implements Calculations {

	@Override
	public int addition(int num1, int num2) {
		int addNums = num1 + num2;
		return addNums;
	}

	@Override
	public int subtraction(int num1, int num2) {
		int subtractNums = num1 - num2;
		return subtractNums;
	}

	@Override
	public int multiplication(int num1, int num2) {
		int multiplyNums = num1 * num2;
		return multiplyNums;
	}

	@Override
	public int division(int num1, int num2) {
		int divideNums = num1 / num2;
		return divideNums;
	}

}
