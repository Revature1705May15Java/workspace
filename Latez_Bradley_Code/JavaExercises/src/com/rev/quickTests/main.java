package com.rev.quickTests;

public class main {
	
	public static int t (int x){
		try{
			System.out.println(x);
			return x;
		}finally{
			return x+1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(t(5));
		
	

	}

}
