package com.rev.threads;

public class MainThreads {
	public static void main(String[] args) {
		Runnable job = new MyRunnable();
		Thread worker1= new Thread(job);
		Thread worker2=new MyThread();
		
		worker1.start();
		worker2.start();
	}
}
