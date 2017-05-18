package com.ex.p1;

public class Fibonacci {
	
	public int[] Fibonaccis(int howmany){
		int[] arrayOut=new int[howmany];
		arrayOut[0]=0;
		arrayOut[1]=1;
		for(int i=2;i<howmany;i++){
			arrayOut[i]=arrayOut[i-2]+arrayOut[i-1];
		}
		return arrayOut;
	}
}
