package com.revature_wk1.arrlist;

import java.util.ArrayList;

public class ArrList 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> simpleArrList = new ArrayList<>();
		
		int num = Integer.parseInt(args[0].toString()); //For testing
		//int num = 10;
		
		
		for(int i = 0; i <= num; i++)
		{
			simpleArrList.add(i);
		}
		
		int even = 0;
		
		for(int j = 0; j <= num; j++)
		{
			if(simpleArrList.get(j) % 2 == 0)
			{
				even += simpleArrList.get(j);
			}
		}
		
		System.out.println(even);
		
		int odd = 0;
		
		for(int k = 0; k <= num; k++)
		{
			if(simpleArrList.get(k) % 2 != 0)
			{
				 odd += simpleArrList.get(k);
			}
		}
		
		System.out.println(odd);
		
		for(int j = 0; j < simpleArrList.size(); j++)
		{	
			if(simpleArrList.get(j) % 9 == 0)
			{
				continue;
			}
			
			if(simpleArrList.get(j) % 2 != 0)
			{
				simpleArrList.remove(j);
				j--;
				continue;
			}
			
		}
		
		System.out.println(simpleArrList);
	}

}
