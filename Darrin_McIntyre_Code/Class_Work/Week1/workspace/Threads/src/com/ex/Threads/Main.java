package com.ex.Threads;

public class Main {

	public static void main(String[] args) {
		Runnable job = new MyRunnable();
		Thread worker1 = new Thread(job);
		Thread worker2 = new MyThread();
		
		worker1.start();
		worker2.start();

	}

}
