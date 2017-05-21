package com.ex.p1;

public class BubbleSort {
	
	/*
	 * Takes in an array of int, then uses the bubble
	 * sort algorithm to return an ordered array
	 */
	public int[] BubbleSortThis (int[] bs){
		int n = bs.length;
		int temp = 0;  
        for(int i=0; i < n; i++){  
        	for(int j=1; j < (n-i); j++){  
        		if(bs[j-1] > bs[j]){  
        			
        			temp = bs[j-1];  
                    bs[j-1] = bs[j];  
                    bs[j] = temp;  
        		}  
                         
        	}  
        } 
		return bs;
	}
	
	public static void main(String[] args) {
		
		/*
		 * Initialize the array an instance of the 
		 * class to call the bubble sort method
		 */
		int[] BSort = {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort bubble = new BubbleSort();
		
		/*
		 * Calls an instance of the BubbleSort class
		 * which uses the BubbleSortThis method
		 * to return the sorted array.
		 */
		BSort = bubble.BubbleSortThis(BSort);
		for(int i=0;i<BSort.length;i++){
			System.out.println(BSort[i]);
		}
			
	}
}
