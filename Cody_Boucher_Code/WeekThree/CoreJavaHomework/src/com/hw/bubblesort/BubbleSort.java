package com.hw.bubblesort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] myArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		System.out.println("Array before sorting");
		for(int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
		bubbleSort(myArray);
		System.out.println("\nArray after sorting");
		for(int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
	}

	private static void bubbleSort(int[] myArray) {
		for(int i = 0; i < myArray.length; i++) {
			for(int j = 0; j < myArray.length-1; j++) {
				if(myArray[j] > myArray[j+1]) {
					int temp = myArray[j];
					myArray[j] = myArray[j+1];
					myArray[j+1] = temp;
				}
			}
		}
	}
}
