package com.ex.threads;

public class MyRunnable implements Runnable{
	
	//StringBuffer sb = new StringBuffer("runnable");
	StringBuilder sb = new StringBuilder("runnable");
	
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
