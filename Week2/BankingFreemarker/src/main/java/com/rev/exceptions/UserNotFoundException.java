package com.rev.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public UserNotFoundException(String username){
		super("The username " + username + " was either not found, or attempted to log in with an invalid password");
	}
}
