package com.ex.threads;

public class TestThread extends Thread {
	
	@Override
	public void run() {
		Thread.State currentState = this.getState();
		System.out.println(currentState);
	}
}
