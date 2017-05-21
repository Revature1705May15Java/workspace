package com.revature_wk1.singleton;

public class Singleton 
{
	private static Singleton singleton = new Singleton();
	
	private Singleton()
	{
		
	}
	
	public static Singleton getInstance()
	{
		return singleton;
	}
	
	protected static void Message()
	{
		System.out.println("Practice Message.");
	}

}
