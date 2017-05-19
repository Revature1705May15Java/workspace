package com.rev.synch;

import java.util.Random;

public class StringThread extends Thread {
	private static final int MAX_WAIT_TIME = 10_000;
	
	private static Random rand;
	
	@Override
	public void run() {
		String threadName = "Thread " + Main.threadNumber++;
		System.out.println(threadName + " entered run()");

		synchRun(threadName);
		unsynchRun(threadName);
		
		System.out.println(threadName + " exiting run()");
	}
	
	private static synchronized void synchRun(String threadName) {
		System.out.println(threadName + " entered synchRun()");
		rand = new Random();
		
		int waitTime = rand.nextInt(MAX_WAIT_TIME);
		
		for(int i = 0; i < waitTime; i++) {
			// Do nothing
		}
		
		Main.synchBuffer.append(Main.synchChar);
		System.out.println(threadName + " appended char to synchBuilder --- result: " + Main.synchBuffer);

		waitTime = rand.nextInt(MAX_WAIT_TIME);
		
		for(int i = 0; i < waitTime; i++) {
			// Do nothing
		}
				
		System.out.println(threadName + " incremented synchChar --- result: " + ++Main.synchChar);
		
		System.out.println(threadName + " exiting synchRun()");
	}
	
	private static void unsynchRun(String threadName) {
		System.out.println(threadName + " entered unsynchRun()");
		rand = new Random();
		
		int waitTime = rand.nextInt(MAX_WAIT_TIME);
		
		for(int i = 0; i < waitTime; i++) {
			// Do nothing
		}
		
		Main.unsynchBuffer.append(Main.unsynchChar);
		System.out.println(threadName + " appended char to unsynchBuilder --- result: " + Main.unsynchBuffer);

		waitTime = rand.nextInt(MAX_WAIT_TIME);
		
		for(int i = 0; i < waitTime; i++) {
			// Do nothing
		}
				
		System.out.println(threadName + " incremented unsynchChar --- result: " + ++Main.unsynchChar);
		
		System.out.println(threadName + " exiting unsynchRun()");
	}
}
