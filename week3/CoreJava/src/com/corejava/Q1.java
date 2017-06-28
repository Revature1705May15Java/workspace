package com.corejava;


public class Q1 {
/*
Perform a bubble sort on the following 
integer array:  1,0,5,6,3,2,3,7,9,8,4

 */
	public static int[] bubbleSort(int[] unsortedarray){
		boolean nosort=true;
		for(int i=0;i<unsortedarray.length-1;i++){
			int firstnum=unsortedarray[i];
			int secondnum=unsortedarray[i+1];
			if(firstnum>secondnum){
				unsortedarray[i]=(int)secondnum;
				unsortedarray[i+1]=(int)firstnum;
				nosort=false;
			}
			if(i==unsortedarray.length-2&&nosort==false){
				bubbleSort(unsortedarray);
			}
		}
		
		return unsortedarray;
	}
	public Q1() {
	}
	public static void main(String[] args) {
		int[] unsorted=new int[]{1,0,5,6,3,2,3,7,9,8,4};
		int[] sorted = bubbleSort(unsorted);
		for(int i=0;i<sorted.length;i++){
		System.out.println(sorted[i]);
		}
	}

}