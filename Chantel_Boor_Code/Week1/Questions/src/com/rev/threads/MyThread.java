package com.rev.threads;

public class MyThread extends Thread
{
	
	StringBuffer sb = new StringBuffer("thread");
	
	public void run(){
		for(int i =0;i<10;i++)
		{
			
			
			System.out.println(sb.append(i));
		}
	}

}
