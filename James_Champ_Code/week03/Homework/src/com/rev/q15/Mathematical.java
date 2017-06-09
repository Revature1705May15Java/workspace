package com.rev.q15;

public interface Mathematical<T extends Number> {
	public T addition(T x, T y);
	public T subtraction(T x, T y);
	public T multiplication(T x, T y);
	public T division(T x, T y);
}
