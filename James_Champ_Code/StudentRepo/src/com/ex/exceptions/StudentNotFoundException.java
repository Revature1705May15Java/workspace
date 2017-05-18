package com.ex.exceptions;

/**
 * This class defines an exception that is thrown when an operation
 * is performed on a student that does not currently exist.
 * 
 * @author James Champ
 */
@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception {
	
	public StudentNotFoundException() {
		
	}
	
	public StudentNotFoundException(String message) {
		super(message);
	}
}
