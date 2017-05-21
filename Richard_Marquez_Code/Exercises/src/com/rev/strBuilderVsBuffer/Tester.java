package com.rev.strBuilderVsBuffer;

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean running = true;

		do {
			System.out.println("\n1. Test multi-threaded StringBuffer");
			System.out.println("2. Test multi-threaded StringBuilder");
			System.out.println("3. Quit");
			
			System.out.print("\nYour choice: ");
			int choice = Integer.parseInt(scan.nextLine());
		
			switch(choice) {
			case 1:
				testStrBuffer();
				break;
			case 2:
				testStrBuilder();
				break;
			case 3:
				running = false;
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (running);
	}
	
	// Thread-safe
	// (run numerous times to check; the length of the final string will never change)
	public static void testStrBuffer() {
		BufferT.strBuf = new StringBuffer();
		
		Runnable job1 = new BufferT('a');
		Runnable job2 = new BufferT('0');
		Runnable job3 = new BufferT('A');
		Runnable job4 = new BufferT('a');
		Runnable job5 = new BufferT('0');
		Runnable job6 = new BufferT('A');
		Runnable job7 = new BufferT('a');
		Runnable job8 = new BufferT('0');
		Runnable job9 = new BufferT('A');
		Runnable job10 = new BufferT('a');
		Runnable job11 = new BufferT('0');
		Runnable job12 = new BufferT('A');
		
		
		Thread worker1 = new Thread(job1);
		Thread worker2 = new Thread(job2);
		Thread worker3 = new Thread(job3);
		Thread worker4 = new Thread(job4);
		Thread worker5 = new Thread(job5);
		Thread worker6 = new Thread(job6);
		Thread worker7 = new Thread(job7);
		Thread worker8 = new Thread(job8);
		Thread worker9 = new Thread(job9);
		Thread worker10 = new Thread(job10);
		Thread worker11 = new Thread(job11);
		Thread worker12 = new Thread(job12);
		
		worker1.start();
		worker2.start();
		worker3.start();
		worker4.start();
		worker5.start();
		worker6.start();
		worker7.start();
		worker8.start();
		worker9.start();
		worker10.start();
		worker11.start();
		worker12.start();
		
		try {
			worker1.join();
			worker2.join();
			worker3.join();
			worker4.join();
			worker5.join();
			worker6.join();
			worker7.join();
			worker8.join();
			worker9.join();
			worker10.join();
			worker11.join();
			worker12.join();
		} catch (Exception e) {
			//
		}
		
		System.out.println("\n\nFINISHED:\n" + BufferT.strBuf);
		
		/*Runnable job1 = new BufferT('a');
		Runnable job2 = new BufferT('0');
		Runnable job3 = new BufferT('A');
		
		Thread worker1 = new Thread(job1);
		Thread worker2 = new Thread(job2);
		Thread worker3 = new Thread(job3);
		
		worker1.start();
		worker2.start();
		worker3.start();*/
	}
	
	// NOT thread-safe
	// cannot guarantee that operations will not overwrite one another
	// (run numerous times to check; length of final string can change)
	public static void testStrBuilder() {
		BuilderT.strBuilder = new StringBuilder();
		
		Runnable job1 = new BuilderT('a');
		Runnable job2 = new BuilderT('0');
		Runnable job3 = new BuilderT('A');
		Runnable job4 = new BuilderT('a');
		Runnable job5 = new BuilderT('0');
		Runnable job6 = new BuilderT('A');
		Runnable job7 = new BuilderT('a');
		Runnable job8 = new BuilderT('0');
		Runnable job9 = new BuilderT('A');
		Runnable job10 = new BuilderT('a');
		Runnable job11 = new BuilderT('0');
		Runnable job12 = new BuilderT('A');
		
		
		Thread worker1 = new Thread(job1);
		Thread worker2 = new Thread(job2);
		Thread worker3 = new Thread(job3);
		Thread worker4 = new Thread(job4);
		Thread worker5 = new Thread(job5);
		Thread worker6 = new Thread(job6);
		Thread worker7 = new Thread(job7);
		Thread worker8 = new Thread(job8);
		Thread worker9 = new Thread(job9);
		Thread worker10 = new Thread(job10);
		Thread worker11 = new Thread(job11);
		Thread worker12 = new Thread(job12);
		
		worker1.start();
		worker2.start();
		worker3.start();
		worker4.start();
		worker5.start();
		worker6.start();
		worker7.start();
		worker8.start();
		worker9.start();
		worker10.start();
		worker11.start();
		worker12.start();
		
		try {
			worker1.join();
			worker2.join();
			worker3.join();
			worker4.join();
			worker5.join();
			worker6.join();
			worker7.join();
			worker8.join();
			worker9.join();
			worker10.join();
			worker11.join();
			worker12.join();
		} catch (Exception e) {
			//
		}
		
		System.out.println("\n\nFINISHED:\n" + BuilderT.strBuilder);

	}
	
}
