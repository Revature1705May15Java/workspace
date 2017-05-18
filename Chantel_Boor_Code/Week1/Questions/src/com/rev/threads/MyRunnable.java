package com.rev.threads;

public class MyRunnable implements Runnable
{
	
	StringBuffer sb = new StringBuffer("run");

	@Override
	public void run() 
	{
		for(int i=0;i<10;i++)
		{
			
			
			System.out.println(sb.append(i));
		}
	}

}
