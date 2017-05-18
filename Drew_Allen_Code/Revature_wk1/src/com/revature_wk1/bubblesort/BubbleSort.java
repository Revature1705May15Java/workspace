package com.revature_wk1.bubblesort;

public class BubbleSort 
{
	public static int[] bubbleSort (int[] exArray)
	{
		 int num = exArray.length;
		 for(int i = 0; i < num-1; i++)
		 {
			 for(int j = 0; j < num-i-1; j++)
			 {
				 if(exArray[j] > exArray[j+1])
				 {
					 int temp = exArray[j];
					 exArray[j] = exArray[j+1];
					 exArray[j+1] = temp;
				 }
			 }
		 }
		 
		 for(int i : exArray)
		 {
			 System.out.println(i);
		 }
		 
		 return exArray;
	}
	 
	/*void printArray(int exArray[])
	{
		int num = exArray.length;
		for(int i = 0; i < exArray.length; i++)
		{
			System.out.println("Sorted array: " + exArray[i] + " ");
			
		}
	}*/
	 
	public static void main(String[] args) 
	{
		// Perform a bubble sort on the following integer array: 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4
		
		BubbleSort bub = new BubbleSort();
		int[] exArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] n = bub.bubbleSort(exArray);
	//	System.out.println("Sorted Array: ");
	//	bub.printArray(exArray);
	}

}
