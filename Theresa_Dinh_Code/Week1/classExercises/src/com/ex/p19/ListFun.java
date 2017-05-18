package com.ex.p19;

import java.util.ArrayList;

public class ListFun 
{
	public static void main(String[] args)
	{
		ListFun l = new ListFun(); 
		ArrayList<Integer> list = new ArrayList<Integer> (); 
		
		for(int i = 1; i <= 10; i++)
			list.add(i); 
		
		System.out.println(list.toString()); 
		System.out.println(l.addEvens(list));
		System.out.println(l.removePrimes(list).toString());
//		System.out.println(list.toString()); 
	}
	
	int addEvens(ArrayList<Integer> list)
	{
		int total = 0; 
		
		for(Integer i : list)
			if(i % 2 == 0)
				total += i;
		
		return total; 			
	}
	
	int addOdds(ArrayList<Integer> list)
	{
		int total = 0; 
		
		for(Integer i : list)
			if(i % 2 != 0)
				total+=i; 

		return total;
	}
	
	// given an ArrayList<Integer>, return a new ArrayList<Integer> of the same list but with 
	// the prime numbers removed 
	ArrayList<Integer> removePrimes(ArrayList<Integer> list)
	{
		ArrayList<Integer> primeless = list; 
		
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i) == 2 | list.get(i) == 3)
			{
				primeless.remove(i--);
				continue; 
			}
			for(double j = 2; j <= Math.sqrt(list.get(i)); j++)
			{
				if(list.get(i) % j == 0)
					break;
				else
					primeless.remove(i--); 
			}
		}	
		return primeless; 
	}
}
