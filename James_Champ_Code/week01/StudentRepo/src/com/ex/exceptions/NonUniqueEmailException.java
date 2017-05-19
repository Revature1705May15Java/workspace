package com.ex.exceptions;

/**
 * This class defines an exception that is thrown when a student's
 * email address is shared with a pre-existing student.
 * 
 * @author James Champ
 */
@SuppressWarnings("serial")
public class NonUniqueEmailException extends Exception {

	public NonUniqueEmailException(String message) {
		super(message);
	}
}
