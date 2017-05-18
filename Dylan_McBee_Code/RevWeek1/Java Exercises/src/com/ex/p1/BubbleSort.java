package com.ex.p1;

public class BubbleSort {
//Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
	
	public static void bubbleSort(int[] numArray){
		//Check length of Array
		int n = numArray.length;
		int temp = 0;
		
		//Start the BubbleSort with Nested Loop
		for(int i=0; i < n; i++){
			for (int j = 1; j < (n-i); j++){
				if(numArray[j-1] > numArray[j]){
					temp = numArray[j-1];
					numArray[j-1] = numArray[j];
					numArray[j] = temp;
				}
			}
		}
	}
	
	public void printArray(int[] numArray){
		for(int i=0; i<numArray.length; i++){
			System.out.println(numArray[i] + " ");
		}
	}
	public int[] sort(int[] numSet){
		int[] x = {0,1,2,3,3,4,5,6,7,8,9};
		return x;
	}
	
	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
		int[] num = {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort.bubbleSort(num);
		b.printArray(num);
	}
}
