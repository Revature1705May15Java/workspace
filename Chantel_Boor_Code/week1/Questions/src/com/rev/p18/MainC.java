package com.rev.p18;

public class MainC 
{
	public static void main(String[] args) 
	{
		UseA a = new UseA();
		String s = "hellO";
		
		boolean b = a.findCap(s);
		String c = a.changeToCap(s);
		a.changeToNum(s);
		
		System.out.println(b);
		System.out.println(c);
	}
	
}
