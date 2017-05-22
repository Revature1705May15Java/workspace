package com.ex.threads;

public class MyThread extends Thread {
	
	StringBuffer sbuf = new StringBuffer("thread");
	StringBuilder sbuilder = new StringBuilder("thread");
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(sbuf.append(i));
		}
	}

}
