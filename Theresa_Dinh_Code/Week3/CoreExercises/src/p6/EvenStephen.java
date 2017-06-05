package p6;

import java.text.DecimalFormat;

public class EvenStephen 
{	
	public boolean isEven(int i)
	{
		// divide by 2, if it has any decimal remainder, not even
		double remainder = i / 2.0; 
		// prepare to format double to 2 decimal points 
		DecimalFormat df = new DecimalFormat("#.00"); 

		// convert into String 
		String check = df.format(remainder); 
		
		// use regex to see if decimal remainder or not 
		if(check.matches("\\d*\\.{1}00"))
			return true; 
		return false; 
	}
}
