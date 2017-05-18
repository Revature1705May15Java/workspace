package com.revature_wk1.inheritance;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Inheritance 
{
	abstract boolean isUpperCase(String s);
	
	abstract String convertLowerToUpper(String s);
	
	abstract int convertToInt(String s);
	
}

public class Inherit extends Inheritance
{
	@Override
	boolean isUpperCase(String s) 
	{
		String regex = "[A-Z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(s);
		
		if(match.find())
		{
			System.out.println("This string contains upper case letters!");
			return true;
		}
		else
			return false;
	}

	@Override
	String convertLowerToUpper(String s) 
	{
		String regex = "[A-Z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(s);
		
		if(match.find())
		{
			System.out.println("Now your string is all upper cased! " + s.toUpperCase());
		}
		else
			return null;
		
		return s;
	}

	@Override
	int convertToInt(String s) 
	{
		int str = Integer.parseInt(s);
		System.out.println("String as a number + 10: " + (str + 10));
		return str + 10;
	}
	
	public static void main(String[] args) 
	{
		Scanner insert = new Scanner(System.in);
		Inherit heir = new Inherit();
		System.out.println("Enter a string: ");
		heir.convertLowerToUpper(insert.nextLine().toString());
		heir.isUpperCase(insert.nextLine().toString());
		heir.convertToInt(insert.nextLine().toString());
	}
	
}
