package com.rev.threads;

public class MyThread implements Runnable{
	
	AbstractStringBuilder sb;
	String saywhat;
	
	MyThread(StringBuffer sb, String a){
		this.sb = sb;
		this.saywhat = a;
	}
	
	@Override
	public void run(){
		
		for(int i = 0; i < 100; i++){
			
			System.out.println(sb.append(saywhat));
			
		}
		
	}
}
