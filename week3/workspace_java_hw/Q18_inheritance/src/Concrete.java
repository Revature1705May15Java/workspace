/*
 * Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass.
 *      Provide the following three implementations in the subclass corresponding to the abstract methods 
 *      in the superclass: 

			1.	Check for uppercase characters in a string, and return �true� or �false� depending if any are found.
			2.	Convert all of the lower case characters to uppercase in the input string, and return the result. 
			3.	Convert the input string to integer and add 10, output the result to the console.
			
		Create an appropriate class having a main method to test the above setup.

 */
public class Concrete extends SuperDuperClass{
	@Override
	boolean checkUpper(String test) {
		if(test.equals(test.toLowerCase())) return false;
		return true;
	}
	
	@Override
	String toUpperCase(String test) {
		String temp = "";
		for(int i = 0; i < test.length(); i++){
			temp += Character.toUpperCase(test.charAt(i));
		}
		return temp;
	}

	@Override
	void convertIntPlusTen(String test) {
		int num;
		try{
			num = Integer.parseInt(test.trim()) + 10;
			System.out.println("Int + 10 = " + num);
		} catch(NumberFormatException e){
			System.out.println("Invalid String.");
		}
	}
}