package com.rev.p3;

public class reverse 
{
	public static void main(String[] args) 
	{
		StringBuilder s = new StringBuilder ("to reverse");
		int l = s.length();
		
		//apppend reverse string
		for(int i =0; i<l;i++)
		{
			s.append(s.charAt(l-1-i));
		}
		
		//delete normal string
		s.delete(0, l);
		
		//print result
		System.out.println(s);
	}
}
