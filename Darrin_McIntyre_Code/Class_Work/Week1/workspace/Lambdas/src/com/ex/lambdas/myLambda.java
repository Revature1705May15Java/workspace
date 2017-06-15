package com.ex.lambdas;

public class myLambda {
	
	public static void main(String[] args) {
		myLambda mine = new myLambda();

		StringTogether excitedString = (String a, String b) -> a + " " + b + "!";
		String answer = mine.toOneString(excitedString, "Hello", "There");
		System.out.println("excitedString: " + answer);
		
		CrazyTruth crazyTruth = (boolean a) -> a ? false:true;
		boolean truth = mine.someCrazyTruth(crazyTruth, true);
		System.out.println("crazyTruth: " + truth);
	}
	
	private String toOneString(StringTogether toOne, String a, String b){
		return toOne.combineString(a, b);
	};
	
	private boolean someCrazyTruth(CrazyTruth cT, boolean a){
		return cT.crazyTruth(a);
	};
	
	
}

interface StringTogether{
	String combineString(String a, String b);
}

interface CrazyTruth{
	boolean crazyTruth(boolean a);
}