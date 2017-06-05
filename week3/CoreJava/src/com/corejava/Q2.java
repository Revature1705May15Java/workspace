package com.corejava;
/*
Write a program to display the 
first 25 Fibonacci numbers beginning at 0
 */
public class Q2 {

	public Q2() {
	}
	public static int[] Fibonaccis(int howmany){
		int[] arrayOut=new int[howmany];
		arrayOut[0]=0;
		arrayOut[1]=1;
		for(int i=2;i<howmany;i++){
			arrayOut[i]=arrayOut[i-2]+arrayOut[i-1];
		}
		return arrayOut;
	}
	public static void main(String[] args) {
		int[] array=Fibonaccis(25);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
