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
		
		
		// Print results when all threads are dead
		boolean doesThreadLive;
		
		do {
			doesThreadLive = false;
			
			for(Thread t : threads) {
				if(t.isAlive()) {
					doesThreadLive = true;
				}
			}
		} while(doesThreadLive);
		
		System.out.println("\nsynchBuffer final result:\t" + synchBuffer);
		System.out.println("unsynchBuffer final result:\t" + unsynchBuffer);
		System.out.println("Buffers contain same String: " + synchBuffer.equals(unsynchBuffer));
		
		System.out.println("\nDifference: ");
		displayMismatchedCharacters(synchBuffer.toString(), unsynchBuffer.toString());
	}
	
	private static void displayMismatchedCharacters(String a, String b) {
		System.out.println(a);
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				System.out.print('|');
			}
			else {
				System.out.print(' ');
			}
		}
		
		System.out.println("\n" + b);
	}
}

