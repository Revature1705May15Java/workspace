package com.exercises;

abstract class GrabFrom{
	abstract boolean checkUpper();
	abstract String toUpper();
	abstract int stringToIntPlusTen();
	
}

public class Q18 extends GrabFrom{


	static boolean checkUpper(String checkstr) {
		boolean hasUpper=false;
		for(int i=0;i<checkstr.length();i++){
			if(Character.isUpperCase((Character) (checkstr.charAt(i)))){
				hasUpper=true;
			}			
		}
		return hasUpper;
	}


	static String toUpper(String changestr){
		String outString="";
		for(int i=0;i<changestr.length();i++){
			
			Character currentChar=(Character) (changestr.charAt(i));
			if(Character.isUpperCase(currentChar)){
				outString=outString+currentChar;
			}else{
				Character newChar=Character.toUpperCase(currentChar);
				outString=outString+newChar;
			}
			}
		return outString;
	}

	static int stringToIntPlusTen(){
		return 0;
	}

	public static void main(String[] args) {
		boolean testUpper=checkUpper("words");
		System.out.println(testUpper);
		String testToUpper=toUpper("WORds");
		System.out.println(testToUpper);
		
		
	}
}
