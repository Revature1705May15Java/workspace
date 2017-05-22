package com.ex.p18;

import java.util.regex.Pattern;

public class Warhol extends Gabo
{

	public static void main(String[] args) 
	{
		Warhol w = new Warhol(); 
		
		String test = "aaaaAAaaaa"; 
		System.out.println(w.hasUppercase(test));
		System.out.println(w.makeLowercase(test));
		w.doMaths("10");
	}
	
	@Override
	// returns true if the given String contains any capital letters at all 
	boolean hasUppercase(String s)
	{
		return Pattern.matches(".*[A-Z]+.*",s); 
	}
	
	@Override
	// returns the given String with all letter lowercase
	String makeLowercase(String s) 
	{
		return s.toLowerCase(); 
	}

	@Override
	// prints the given String of a number + 10
	int doMaths(String s) 
	{
		System.out.println(Integer.parseInt(s) + 10);
		return (Integer.parseInt(s) + 10); 
	}

}
