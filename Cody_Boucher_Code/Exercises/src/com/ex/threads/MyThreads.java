package com.ex.threads;

public class MyThreads extends Thread{
	
	//StringBuffer sb = new StringBuffer("thread");
	StringBuilder sb = new StringBuilder("thread");
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(sb.append(i));
		}
	}
	
	public void run(StringBuilder sb) {
		for(int i = 0; i < 10; i++) {
			System.out.println(sb.append(i));
		}
	}
	
	public void run(StringBuffer sb) {
		for(int i = 0; i < 10; i++) {
			System.out.println(sb.append(i));
		}
	}

}
