package com.rev.p5;

public class Substring 
{
	public static void main(String[] args) 
	{
		String s = "make a substring";
		
		String a = makeSubstring (s,0);
		System.out.println(a);
		
		a = makeSubstring(s,5);
		System.out.println(a);
	}
	
	public static String makeSubstring (String s, int n)
	{
		String temp = "";
		
		for(int i = 0; i<=n;i++)
		{
			temp += s.charAt(i);
		}
		
		return temp;
		
	}
}
