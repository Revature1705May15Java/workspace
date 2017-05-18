package com.ex.p3;

public class Factorial 
{
	public int doThing(int n)
	{	
		if(n <= 0)
			return 1; 
		return n * doThing(--n); 
	}
}
