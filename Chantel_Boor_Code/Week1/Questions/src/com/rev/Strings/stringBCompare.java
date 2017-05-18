package com.rev.Strings;

public class stringBCompare 
{
	
	public static void main(String[] args) 
	{
		String str = "hello";
		StringBuilder sbuild = new StringBuilder(str);
		StringBuffer sbuff = new StringBuffer(str);
		
		str = str.concat(" world");
		sbuild.append(" world");
		sbuff.append(" world");
		
		//System.out.println(str);
		//System.out.println(sbuild);
		//System.out.println(sbuff);
		
		String a = "hi";
		String b = "hi";
		System.out.println(a==b);
		b = new String("hi");
		System.out.println(a==b);
		System.out.println(".equals " + a.equals(b));
		a = b;
		System.out.println(a==b);
	}
	
}
