package com.rev.threads;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable job = new MyRunnable();
		Thread worker1 = new Thread(job);
		Thread worker2 = new MyThread();
		
		worker1.start();
		worker2.start();
		
		StringBuilder sb = new StringBuilder("Hello");
		
		
		

	}

}
