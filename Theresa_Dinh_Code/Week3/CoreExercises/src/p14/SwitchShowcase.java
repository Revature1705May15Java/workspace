package p14;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SwitchShowcase 
{
	public static void main(String[] args)
	{
		int num = 2; 
		int root = 666; 
		
		switch(num)
		{
			case 1: //prints squareroot
			{
				System.out.println(Math.sqrt(root));
				break; 
			}
			case 2: // prints current date time
			{
				Calendar cal = new GregorianCalendar(); 
				System.out.println(cal.getTime());
				break; 
			}
			case 3: // splits string into array 
			{
				String str = "I am learning Core Java"; 
				String[] array = str.split(" "); 
				break; 
			}
		}
	}
}
