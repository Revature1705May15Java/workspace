package com.rev.q15;

public class IntegerOperations implements Mathematical<Integer> {

	@Override
	public Integer addition(Integer x, Integer y) {
		return x + y;
	}

	@Override
	public Integer subtraction(Integer x, Integer y) {
		return x - y;
	}

	@Override
	public Integer multiplication(Integer x, Integer y) {
		return x / y;
	}

	@Override
	public Integer division(Integer x, Integer y) {
		return x * y;
	}

}
