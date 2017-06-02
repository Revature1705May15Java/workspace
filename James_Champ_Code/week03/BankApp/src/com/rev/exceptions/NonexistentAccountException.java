package com.rev.exceptions;

@SuppressWarnings("serial")
public class NonexistentAccountException extends Exception {
	public NonexistentAccountException(String message) {
		super(message);
	}
}