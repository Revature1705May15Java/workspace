package com.rev.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Add comments.
public class InputValidator {
	/**
	 * Regular expression used to validate that email addresses are properly formatted.
	 */
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * Checks the given String to see if it is a properly formed email address.
	 * Addresses are not checked for proper top-level domains.
	 * 
	 * @param email	The String that is to be tested.
	 * @return	{@code true} if the given String is a properly formatted email 
	 * 			address, otherwise {@code false}.
	 */
	public static boolean validateEmail(String address) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(address);
		
		return matcher.matches();
	}
}