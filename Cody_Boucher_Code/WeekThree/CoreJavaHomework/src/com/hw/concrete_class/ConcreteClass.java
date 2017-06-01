package com.hw.concrete_class;

public class ConcreteClass extends AbstractClass{
	
	public static void main(String[] args) {
		ConcreteClass cc = new ConcreteClass();
		String testString = "TeStinG";
		String numberString = "20";
		cc.checkCapitalize(testString);
		cc.capitalize(testString);
		cc.convert(numberString);
	}

	@Override
	public boolean checkCapitalize(String str) {
		boolean hasUpperCase = !str.equals(str.toLowerCase());
		if(hasUpperCase = true) {
			System.out.println("True");
			return true;
		}
		System.out.println("False");
		return false;
	}

	@Override
	public String capitalize(String str) {
		String newString = str.toUpperCase();
		System.out.println(newString);
		return newString;
	}

	@Override
	public int convert(String str) {
		int result = Integer.parseInt(str);
		result += 10;
		System.out.println(result);
		return result;
	}

}
