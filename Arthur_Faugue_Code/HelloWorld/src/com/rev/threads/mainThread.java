package com.rev.threads;

public class mainThread {
	
	public static void main(String[] args) {
		
		Runnable job = new myRunnable();
		Thread worker1 = new Thread(job);
		
		Thread worker2 = new myThread();
		
		worker1.start();
		worker2.start();
		
		
	}
}