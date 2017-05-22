package com.ex.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ex.dao.IoDAO;

public class InputValidator {
	/**
	 * Regular expression used to validate that email addresses are properly formatted.
	 */
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * Checks the given String to see if it is a properly formed email address.
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
	
	/**
	 * Checks the given string for the presence of the delimiter used
	 * when writing data to a file.
	 * 
	 * @param name	The name that is being validated.
	 * @return	{@code true} if the given string contains one or more
	 * 			occurrences of the delimiter, and {@code false} otherwise.
	 */
	public static boolean validateName(String name) {
		return name.contains(IoDAO.DELIMITER);
	}
}
