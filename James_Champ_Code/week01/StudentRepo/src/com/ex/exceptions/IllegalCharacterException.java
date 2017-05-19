package com.ex.exceptions;

/**
 * Defines an exception that is thrown when a student's name
 * contains the delimiter that is used in the student data 
 * storage file.
 * 
 * @author James Champ
 */
@SuppressWarnings("serial")
public class IllegalCharacterException extends Exception {

	public IllegalCharacterException(String message) {
		super(message);
	}
}
