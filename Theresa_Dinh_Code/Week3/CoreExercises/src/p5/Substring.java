package p5;

import java.util.ArrayList;

public class Substring 
{
	public String substring(String str, int index)
	{
		ArrayList<Character> list = new ArrayList<Character>(); 
		String sub = ""; 
		
		// put all chars in a string in arraylist
		for(int i = 0; i < str.length(); i++)
		{
			list.add(str.charAt(i)); 
		}
		
		// then get all the chars in the substring specified(0, index-1)
		for(int i = 0; i < index -1; i++)
		{
			sub = sub.concat(list.get(i).toString()); 
		}
		return sub; 
	}
}
