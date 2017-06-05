/*
 * Q16. Write a program to display the number of characters for a string input.
 *      The string should be entered as a command line argument using (String [ ] args).
 */
public class CMDArgs {

	public static void main(String[] args) {
		if(args.length > 0){	
			String input = args[0];
			System.out.println(input.length());
		} else System.out.println("No input given.");
	}

}