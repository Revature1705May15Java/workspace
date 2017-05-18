package week1.assignment1.q18;

public class ConcreteExample extends AbstractExample {

	@Override
	/*
	 * Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	 */
	public boolean hasUpper(String s) {
		for (int i = 0; i < s.length(); i++){
			if (Character.isUpperCase(s.charAt(i)))
				return true;
		}
		return false;
	}

	@Override
	/*
	 * Convert all of the lower case characters to uppercase in the input string, and return the result.
	 */
	public String toUpper(String s) {
		return s.toUpperCase();
	}

	@Override
	/*
	 * Convert the input string to integer and add 10, output the result to the console.
	 */
	public int addTen(String s) {
		try {
			return Integer.parseInt(s) + 10;
		}
		catch (NumberFormatException e) {
			System.out.println("The string does not contain a valid number");
		}
		return Integer.MIN_VALUE;
	}

}
