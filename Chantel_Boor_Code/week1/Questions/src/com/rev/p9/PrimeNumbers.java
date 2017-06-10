package com.rev.p9;

import java.util.ArrayList;

public class PrimeNumbers 
{
	public static void main(String[] args) 
	{

		//used to call find primes
		ArrayList <Integer> num = new ArrayList <Integer>();
		PrimeNumbers p = new PrimeNumbers();
		
		//used to store result and testing
		ArrayList <Integer> primes = new ArrayList <Integer>();
		
		//add numbers
		for(int i = 1;i<=100;i++)
		{
			num.add(i);
		}
		
		primes = p.findPrime(num);
	}
	
	ArrayList <Integer> findPrime(ArrayList<Integer> p) 
	{
		ArrayList <Integer> result= new ArrayList <Integer>();
		boolean divisable = false; //used to help elminate numbers divisable by odds
		
		for(int i =0;i<p.size();i++)
		{
			
			//special cases for 1 and 2
			if(p.get(i) == 1)
				continue;
			if(p.get(i) == 2)
			{
			    System.out.print(p.get(i) + " ");
			    result.add(p.get(i));
			    continue;
			}
			//check divisable by evans
		    if (p.get(i)%2==0) 
		    	continue; 
		    //divisable by odds
		    for(int j=3;j*j <=p.get(i);j+=2) 
		    {
		        if(p.get(i)%j==0)
		        {
		          divisable = true;
		        }
		    }
		    
		    if(divisable)
		    {
		    	divisable = false;
		    	continue;
		    }
		    
		    //only gets her to print/add if prime
		    System.out.print(p.get(i) + " ");
		    result.add(p.get(i));
		}
		
		return result;
	}
}
