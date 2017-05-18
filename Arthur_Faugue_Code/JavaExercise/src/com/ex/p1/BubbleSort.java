package com.ex.p1;

public class BubbleSort {
	
	int[] BubbleSortThis (int[] BSort){
		
		int Temp;
		
		for(int x = 1 ;x < BSort.length ; x++){
			if(BSort[x-1] > BSort[x]){
				
				Temp = BSort[x-1];
				BSort[x-1] = BSort[x];
				BSort[x] = Temp;
			}
		}
		return BSort;
	}
	
	public static void main(String[] args) {
		
		int[] BSort = {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort Bubble = new BubbleSort();
		Bubble.BubbleSortThis(BSort);
		
	}
}
