package tests;

public class checkInput {

	boolean truth = false;
	
	public boolean check(String input, int count){
		try{
			Integer.parseInt(input);
			truth = true;
		} catch (NumberFormatException e){
			if(count > 0) System.out.println("Error: Invalid entry, please enter a number.");
			truth = false;
		}
		return truth;
	}
}
