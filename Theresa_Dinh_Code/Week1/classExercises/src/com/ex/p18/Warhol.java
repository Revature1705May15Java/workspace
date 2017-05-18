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
	boolean hasUppercase(String s)
	{
		return Pattern.matches(".*[A-Z]+.*",s); 
	}
	
	@Override
	String makeLowercase(String s) 
	{
		return s.toLowerCase(); 
	}

	@Override
	void doMaths(String s) 
	{
		System.out.println(Integer.parseInt(s) + 10);
	}

}
