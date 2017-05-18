package com.revature_wk1.threads;

public class MyRunnable implements Runnable
{

	/*public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}*/
	
	StringBuffer sb = new StringBuffer("runnable");
	
	@Override
	public void run() 
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println(sb.append(i));
		}
		
	}

}
