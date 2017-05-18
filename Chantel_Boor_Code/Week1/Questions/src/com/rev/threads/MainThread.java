package com.rev.threads;

public class MainThread
{
	
		public static void main(String[] args)
		{
			Runnable job = new MyRunnable();
			Thread worker1 = new Thread(job);
			
			Thread worker2  = new Thread(job);
			
			worker1.start();
			worker2.start();
		}
		

}
