package com.rev.p19;

import java.util.ArrayList;

public class ArrayListStuff 
{
	public static void main(String[] args) 
	{
		ArrayList <Integer> num = new ArrayList <Integer>();
		
		//varibles and list for methods
		ArrayListStuff als = new ArrayListStuff();
		int odd;
		int even;
		ArrayList <Integer> withoutPrime = new ArrayList <Integer>();
		
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(4);
		num.add(5);
		num.add(6);
		num.add(7);
		num.add(8);
		num.add(9);
		num.add(10);
		
		even = als.addEven(num);
		odd = als.addOdd(num);
		withoutPrime = als.RemovePrime(num);
	}
	
	int addEven (ArrayList <Integer> n)
	{
		
		int x =0;
		
		for(int i=0;i<n.size();i++)
		{
			if(n.get(i)%2 == 0)
				x = x+n.get(i);
		}
		
		System.out.println(x);
		return x;
	}
	
	int addOdd (ArrayList <Integer> n)
	{
		int x =0;
		
		for(int i=0;i<n.size();i++)
		{
			if(n.get(i)%2 == 1)
				x = x+n.get(i);
		}
		
		System.out.println(x);
		return 0;
	}
	
	ArrayList <Integer> RemovePrime (ArrayList <Integer> n)
	{
		
		ArrayList <Integer> result= new ArrayList <Integer>();
		boolean divisable = false; //used to help elminate numbers divisable by odds
		
		for(int i =0;i<n.size();i++)
		{
			
			//special cases for 1 and 2
			if(n.get(i) == 1)
			{
				result.add(n.get(i));
				continue;
			}
			if(n.get(i) == 2)
			{
			    continue;
			}
			//check divisable by evans
		    if (n.get(i)%2==0)
		    {
			    result.add(n.get(i));
		    	continue;
		    } 
		    //divisable by odds
		    for(int j=3;j*j <=n.get(i);j+=2) 
		    {
		        if(n.get(i)%j==0)
		        {
		          divisable = true;
		        }
		    }
		    
		    if(divisable)
		    {
			    result.add(n.get(i));
		    	divisable = false;
		    	continue;
		    }
		    
		}
		
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i) + " ");
		
		System.out.println();
		return result;
	}

}
