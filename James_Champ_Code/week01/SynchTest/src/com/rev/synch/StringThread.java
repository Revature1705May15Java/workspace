package com.rev.synch;

import java.util.Random;

public class StringThread extends Thread {
	private static final int MAX_WAIT_TIME = 500;
	
	private static Random rand;
	private int id;
	
	public StringThread(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		String threadName = "Thread " + id;
		System.out.println(threadName + " entered run()");

		synchRun(threadName);
		unsynchRun(threadName);
		
		System.out.println(threadName + " exiting run()");
	}
	
	private static synchronized void synchRun(String threadName) {
		System.out.println(threadName + " entered synchRun()");
		rand = new Random();
		
		int waitTime = rand.nextInt(MAX_WAIT_TIME) + 1;
		
		try {
			System.out.println(threadName + " sleeps for " + waitTime + "ms");
			sleep(waitTime);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(threadName + " is running again");
		
		Main.synchBuffer.append(Main.synchChar);
		System.out.println(threadName + " appended char to synchBuffer --- result: " + Main.synchBuffer);

		waitTime = rand.nextInt(MAX_WAIT_TIME) + 1;
		
		try {
			System.out.println(threadName + " sleeps for " + waitTime + "ms");
			sleep(waitTime);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(threadName + " is running again");
		System.out.println(threadName + " incremented synchChar --- result: " + ++Main.synchChar);
		
		System.out.println(threadName + " exiting synchRun()");
	}
	
	private static void unsynchRun(String threadName) {
		System.out.println(threadName + " entered unsynchRun()");
		rand = new Random();
		
		int waitTime = rand.nextInt(MAX_WAIT_TIME) + 1;
		
		try {
			System.out.println(threadName + " sleeps for " + waitTime + "ms");
			sleep(waitTime);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(threadName + " is running again");
		
		Main.unsynchBuffer.append(Main.unsynchChar);
		System.out.println(threadName + " appended char to unsynchBuffer --- result: " + Main.unsynchBuffer);

		waitTime = rand.nextInt(MAX_WAIT_TIME) + 1;
		
		try {
			System.out.println(threadName + " sleeps for " + waitTime + "ms");
			sleep(waitTime);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(threadName + " is running again");
		
		System.out.println(threadName + " incremented unsynchChar --- result: " + ++Main.unsynchChar);
		
		System.out.println(threadName + " exiting unsynchRun()");
	}
}
