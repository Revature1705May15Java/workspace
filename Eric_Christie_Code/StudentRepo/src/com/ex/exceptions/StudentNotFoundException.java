package com.ex.exceptions;

public class StudentNotFoundException extends Exception {

	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = 2558419661926446302L;

	public StudentNotFoundException() {
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
