package com.rev.synch;

public class Main {
	protected static StringBuffer synchBuffer;
	protected static StringBuffer unsynchBuffer;
	protected static char synchChar;
	protected static char unsynchChar;
	protected static int threadNumber;
	
	public static void main(String[] args) {
		run();
	}

	private static void run() {
		synchChar = 'a';
		unsynchChar = 'a';
		
		synchBuffer = new StringBuffer();
		unsynchBuffer = new StringBuffer();
		
		Thread[] threads = new StringThread[26];
		
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new StringThread();
		}
		
		threadNumber = 1;
		
		for(int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		for(long i = 0; i < 2_000_000_000; i++) {
			// Do nothing...
		}
		
		System.out.println("\nsynchBuffer final result:\t" + synchBuffer);
		System.out.println("unsynchBuffer final result:\t" + unsynchBuffer);
	}
}

