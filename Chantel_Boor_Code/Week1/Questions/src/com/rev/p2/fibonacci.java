package com.rev.p2;

public class fibonacci 
{
	

	public static void main(String[] args)
	{
		int x =5;
		
		fibonacci f = new fibonacci();
		int[] solved = f.sequence(x);
		
		
		//prints array
		for(int i=0;i<solved.length;i++)
		{
			System.out.print(solved[i]+" ");
		}

	}
	
	int [] sequence (int num)
	{
		//creates empty array with specified number of elements
		int [] fs = new int[num]; 
		
		//loop that adds elements to array
		for(int i=0;i<num;i++)
		{
			
			//Statement makes first two elements 0 and 1 and the rest additions 
			// of the previous two elements following the rules of a fibonacci sequence
			if(i == 0)
			{
				fs[i] = 0;
			}
			else if(i == 1)
			{
				fs[i] = 1;
			}
			else
			{
				fs[i] = fs[i-1] + fs[i-2];
			}
		}
		
		//returns array with specified sequence length
		return fs;
	}

}
