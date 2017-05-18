package com.rev.lambdas;

public class AnonRunnable {
	public static void main(String[] args) {
		// anon class
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("running anon");
			}
		};
		
		// lambda
		Runnable r2 = ()->System.out.println("running lambda");
		
		Thread t1 = new Thread(r1);
		t1.run();
		
		Thread t2 = new Thread(r2);
		t2.run();
	}
}
