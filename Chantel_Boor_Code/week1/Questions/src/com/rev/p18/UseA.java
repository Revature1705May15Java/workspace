package com.rev.p18;

public class UseA extends AbstractC
{

	@Override
	boolean findCap(String s) 
	{
		//used to see if there is capital letter assumes false
		boolean b = false;
		
		//loop goes through string in checks if character is capital letter
		for(int i=0;i<s.length();i++)
		{
			if((s.charAt(i) > 64) && (s.charAt(i) < 91))
			{
				b = true;
			}
		}
		
		return b;
	}

	@Override
	String changeToCap(String s) 
	{
		String c = s.toUpperCase();
		
		return c;
	}

	@Override
	void changeToNum(String s)
	{
		int x = (int)s.codePointAt(0);
		
		System.out.println(x+10);
	}

}
