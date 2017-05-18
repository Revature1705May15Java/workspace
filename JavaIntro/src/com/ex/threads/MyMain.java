package com.ex.threads;

public class MyMain {

	public static void main(String[] args) {
		
		StringBuilder sbuild = new StringBuilder("multi-thread builder");
		StringBuffer sbuff = new StringBuffer("multi-thread buffer");
		
		Runnable job = new MyRunnable();
		Thread worker1 = new Thread(job);
		Thread worker2 = new MyThread();
		Thread worker3 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(sbuild.append(i));
				System.out.println(sbuff.append(i));
			}
		});
		Thread worker4 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(sbuild.append(i));
				System.out.println(sbuff.append(i));
			}
		});
		
//		worker1.start();
//		worker2.start();
		worker3.start();
		worker4.start();
		
	}

}
