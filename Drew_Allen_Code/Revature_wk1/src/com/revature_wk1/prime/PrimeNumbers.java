package com.revature_wk1.prime;

import java.util.ArrayList;

public class PrimeNumbers 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		
		int num = 100;
		
		for(int i = 2; i <= num; i++)
		{
			primeNumbers.add(i);
		}
		
		for(int j = 0; j < primeNumbers.size(); j++)
		{
			if(primeNumbers.get(j) == 2 || primeNumbers.get(j) == 3 || primeNumbers.get(j) == 5 || primeNumbers.get(j) == 7)
				continue;
			
			if(primeNumbers.get(j) % 2 == 0)
			{
				primeNumbers.remove(j);
				j--;
				continue;
			}
			
			if(primeNumbers.get(j) % 3 == 0)
			{
				primeNumbers.remove(j);
				j--;
				continue;
			}
			
			if(primeNumbers.get(j) % 5 == 0)
			{
				primeNumbers.remove(j);
				j--;
				continue;
			}
			
			if(primeNumbers.get(j) % 7 == 0)
			{
				primeNumbers.remove(j);
				j--;
				continue;
			}
		}
		
		System.out.println(primeNumbers);
	}

}
