package com.ex.p1;

public class BubbleSort 
{
	public int[] sort(int[] array)
	{
		int[] out = array.clone();
		
		for(int i= 0; i < out.length-1; i++)
		{
			//swap or continue check
			if(out[i] > out[i+1]) //check if element larger than one after it
			{
				int firstTemp = out[i+1]; //holds og value so we can swap out values
				out[i+1] = out[i]; 
				out[i] = firstTemp; 			
			}
			else
			{
				for(int j = 0; j < out.length-1; j++)
				{
					if(out[j] > out[j+1])
					{
						int secondTemp = out[j+1]; 
						out[j+1] = out[j]; 
						out[j] = secondTemp; 
						
					}
				}
			}
		}
		return out;
	}

	/*
	public static void main(String[] args) 
	{
		int[] array = {1,0,5,6,3,2,3,7,9,8,4}; 
		
		for(int i= 0; i < array.length-1; i++)
		{
			//swap or continue check
			if(array[i] > array[i+1]) //check if element larger than one after it
			{
				int firstTemp = array[i+1]; //holds og value so we can swap array values
				array[i+1] = array[i]; 
				array[i] = firstTemp; 			
			}
			else
			{
				for(int j = 0; j < array.length-1; j++)
				{
					if(array[j] > array[j+1])
					{
						int secondTemp = array[j+1]; 
						array[j+1] = array[j]; 
						array[j] = secondTemp; 
						
					}
				}
			}
		}
		System.out.print("array: { ");
		for(int i : array)
		{
			System.out.print(i + " ");
		}
		System.out.println("}");
	 */
	
}