package com.corejava;
/*
Write a program having a concrete subclass that 
inherits three abstract methods from a superclass.  
Provide the following three implementations in the 
subclass corresponding to the abstract methods in the 
superclass: 

Check for uppercase characters in a string, 
 and return �true� or �false� depending if any are found.
Convert all of the lower case characters to uppercase 
 in the input string, and return the result. 
Convert the input string to integer and add 10, output 
 the result to the console.
Create an appropriate class having a main method to test 
 the above setup.

 */
public class Q18{
	public static void main(String[] args) {
		Q18c q = new Q18c();
		String str="WonDerFul";
		String numstr="10";
		System.out.println(q.Q18mHasUpper(str));
		System.out.println(q.Q18mToUpper(str));
		System.out.println(q.Q18mToIntPlusTen(numstr));
	}

}
class Q18c extends Q18a{
	@Override
	boolean Q18mHasUpper(String str) {
		boolean hasupper=false;
		for(int i=0;i<str.length();i++){
			if(Character.isUpperCase(str.charAt(i))){
				hasupper=true;
			}
		}
		return hasupper;
	}

	@Override
	String Q18mToUpper(String str) {
		String newstr = str.toUpperCase();
		return newstr;
	}

	@Override
	int Q18mToIntPlusTen(String str) {
		try{
			int numout=Integer.parseInt(str);
			return numout+10;
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return 0;
	}
}
abstract class Q18a{
	abstract boolean Q18mHasUpper(String str);
	abstract String Q18mToUpper(String str);
	abstract int Q18mToIntPlusTen(String str);
}
