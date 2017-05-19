package com.ex.exceptions;

/**
 * This class defines an exception that is thrown when a student's email
 * address is not valid.
 * 
 * @author James Champ
 *
 */
@SuppressWarnings("serial")
public class InvalidEmailException extends Exception {

	public InvalidEmailException(String message) {
		super(message);
	}
}
