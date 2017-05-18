package com.ex.threads;

public class Main {
	public static void main(String[] args) {
		
		Runnable job = new MyRunnable();
		Thread worker1 = new Thread(job);
		Thread worker2 = new MyThreads();
		
		worker1.start();
		worker2.start();
	}

}
