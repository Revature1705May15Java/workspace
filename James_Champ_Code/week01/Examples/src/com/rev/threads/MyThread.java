package com.rev.threads;

public class MyThread extends Thread {
	
	StringBuilder sb = new StringBuilder("thread");
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(sb.append(i));
		}
	}
}
