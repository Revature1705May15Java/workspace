package com.rev.lambdas;

import java.util.Arrays;
import java.util.List;

public class LambdaPractice
{
	public static void main(String[] args)
	{
		
		List<String> list = Arrays.asList("Boor","Baker","Funk", "Smith","Addison");
		
		
		StartsWith create = (List<String> s, String f) ->
		{
			
		
		for(int i=0;i<s.size();i++)
		{
			if(s.get(i).startsWith(f))
			{
				System.out.println(s.get(i));
			}
			
		}
			
		};
		
		MakeWith m = (List<String> s, String f) ->
		{
			
		
		for(int i=0;i<s.size();i++)
		{

			System.out.print(s.get(i) + f);
			
		}
			
		};
		
		create.operation(list, "B");
		m.operation(list, "s: \n");
	}
}
interface StartsWith
{
	void operation(List<String> s, String f);
}

interface MakeWith
{
	void operation(List<String> s, String f);
}

