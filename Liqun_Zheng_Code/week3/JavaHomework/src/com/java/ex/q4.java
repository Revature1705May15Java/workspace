package com.java.ex;

public class q4 {
	public int fac(int x){
		int result=1;
		if(x==0||x==1){
			return x;
		}
		for(int i=1; i<x; i++){
			result = result*i;
		}
		return result;
	}
	public static void main(String [] args)
	{
		
	}
}
