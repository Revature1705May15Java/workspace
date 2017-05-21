package com.ex.pl;

public class BubbleSort {
	public int[] sortArray(int [] x){
		int temp=0;
		
		for(int i =1; i<x.length; i++)
		{
			for(int j=1; j<x.length;j++)
				if(x[j-1]>x[j])
				{
					temp = x[j-1];
					x[j-1]= x[j];
					x[j]=temp;
			}
		}
		return x;
	}
	public void printArray(int[] x){
		for (int i =0; i<x.length; i++)
		{
			System.out.print(x[i]+", ");
		}
		
	}
	
	
	public static void main(String [] args)
	{
		
		int[] num = {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort b = new BubbleSort();
		num = b.sortArray(num);
		b.printArray(num);
	}
}
