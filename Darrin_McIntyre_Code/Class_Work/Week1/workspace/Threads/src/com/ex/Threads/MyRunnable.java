package com.ex.Threads;

public class MyRunnable implements Runnable{

	StringBuffer sb = new StringBuffer("runnable");
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) System.out.println(sb.append(i));
		
	}
	

}
