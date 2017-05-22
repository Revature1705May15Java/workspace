package com.ex.p9;

import java.util.ArrayList;

public class PrimeList 
{
	public static void main(String[] main)
	{
		ArrayList<Integer> list = new ArrayList<Integer> (); 
		for(int i = 1; i <= 100; i++)
		{
			list.add(i); 
		}
		System.out.println(findPrimes(list).toString()); 
	}
	static public ArrayList<Integer> findPrimes(ArrayList<Integer> list)
	{
		ArrayList<Integer> primes = new ArrayList<Integer>(); 
		
		for(Integer i : list)
		{
			if(i == 1)
				continue; 
			if(i == 2 | i == 3)
			{
				primes.add(i); 
				continue; 
			}
			boolean isPrime = true; 
			for(double j = 2; j <= Math.sqrt(i); j++)
			{
				if(i % j == 0)
					isPrime = false; 
			}
			if(isPrime)
				primes.add(i);  
			
//			System.out.println(primes.toString());
		}
//		System.out.println(primes.toString());
		return primes; 
//		return true;
	}
}
