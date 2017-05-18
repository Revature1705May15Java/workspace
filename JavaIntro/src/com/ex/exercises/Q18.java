package com.ex.exercises;

public class Q18 extends Super {


	boolean checkForUppercase(String s) {
		return !s.equals(s.toLowerCase());
	}
	
	String toUppercase(String s) {
		return s.toUpperCase();
	}
	
	void printToIntPlus10(String s) {
		int result = Integer.parseInt(s) + 10;
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		Q18 q = new Q18();
		System.out.println("Should say false: " + q.checkForUppercase("false"));
		System.out.println("Should say true: " + q.checkForUppercase("TRUE"));
		System.out.println("Converting to all uppercase: " + q.toUppercase("blah blah blah"));
		try {
			q.printToIntPlus10("12345");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

abstract class Super {
	abstract boolean checkForUppercase(String s);
	abstract String toUppercase(String s);
	abstract void printToIntPlus10(String s);
}