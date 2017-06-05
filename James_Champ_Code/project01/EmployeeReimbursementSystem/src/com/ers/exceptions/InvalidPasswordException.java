package com.ers.exceptions;

@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String message) {
		super(message);
	}
}
