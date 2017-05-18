package com.revature.threads;

public class MainThread 
{

	public static void main(String[] args) 
	{
		Runnable job = new MyRunnable();
		Runnable jewb = new MyRunnable();
		
		Thread worker = new Thread(job);
		Thread workHer = new Thread(jewb);
		
		Thread woker = new Thread(jewb);
		Thread werker = new Thread(job);
		
		worker.start();
		workHer.start();
		woker.start();
		werker.start();
	}

}
