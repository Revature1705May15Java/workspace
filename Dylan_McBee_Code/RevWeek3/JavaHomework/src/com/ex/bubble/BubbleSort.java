package com.ex.bubble;

public class BubbleSort {

	private void bubbleSort(int[] numArray){
		int n = numArray.length;
		int temp = 0;
		
		//Start sort
		
		for(int i=0; i < n; i++){
			for (int j = 1; j < (n-i); j++){
				if(numArray[j-1]>numArray[j]){
					temp = numArray[j-1];
					numArray[j-1] = numArray[j];
					numArray[j] = temp;
				}
			}
		}
	}
	private void printArray(int[] numArray){
		for(int i=0; i<numArray.length; i++){
			System.out.println(numArray[i] + " ");
		}
	}
	
	private int[] sort(int[] numSet){
		int[] x = {0,1,2,3,3,4,5,6,7,8,9};
		return x;
	}
	
	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
		int[] num = {1,0,5,6,3,2,3,7,9,8,4};
		b.bubbleSort(num);
		b.printArray(num);
	}
}
