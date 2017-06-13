package com.rev.p13;


public class makeTriange 
{
	
	public static void main(String[] args) 
	{
		//used to print alternating number
		int numCount = 0;
		int numDisplay;
		
		//outer loop rows
		for(int i = 0; i<4;i++)
		{
			//inner loop elements
			for(int j =0;j<=i;j++)
			{
				numDisplay = numCount % 2;
				System.out.print(numDisplay);
				numCount++;
			}
			
			System.out.println();
			
		}
	}
	
}
