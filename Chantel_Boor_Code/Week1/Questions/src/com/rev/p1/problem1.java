package com.rev.p1;

public class problem1 
{
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int [] integers = {1,0,5,6,3,2,3,7,9,8,4}; //unsorted array to send to method
		int [] solved; // stores returned array
		
		//creates object and calls sort
		problem1 bs = new problem1();
		solved = bs.sort(integers);
		
		
		//prints array
		for(int i=0;i<solved.length;i++)
		{
			System.out.print(solved[i]+" ");
		}

		
	}
	
	int [] sort (int [] num)
	{
		//used to temporarily store numbers while values are being swapped
		int temp;
		
		
		//goes through array and swaps if current number is greater than next number 
		//until whole array is sorted
		for(int i=0;i<num.length-1;i++)
		{
			for(int j =0; j<num.length-i-1;j++)
			{
				if(num[j]>num[j+1])
				{
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}

				
		
		return num;
	}


}
