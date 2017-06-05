package com.ers.exceptions;

@SuppressWarnings("serial")
public class NoSuchEmployeeException extends Exception {
	public NoSuchEmployeeException(String message) {
		super(message);
	}
}
