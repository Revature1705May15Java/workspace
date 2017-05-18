package com.rev.lambdas;

public class RunnableTest {

	/*
	 *  A bit about lambdas:
	 *  	So the purpose of lambdas, like anonymous classes, is to override methods 
	 *  	The difference between lambdas and anonymous classes is that AC's can 
	 *  	override methods in interfaces, abstract classes, and concrete classes by 
	 *  	explicitly naming the method to be overridden, whereas lambdas override
	 *  	the one and only method in what's called a functional interface (an interface
	 *  	with one and only one abstract method).
	 *  	By implementing said method, we can now create an instance of an 
	 *  	interface with the functionality specified in the lambda
	 */



	/*
	 * Per this example:
	 * Runnable interface has one and only one method to override: run(), 
	 * making it a functional interface
	 * Can we instantiate interfaces? Not without either an anon class or lambda
	 */

	public static void main(String[] args) {

		//Anonymous class runnable 

		/*
		 *  here we write the full syntax that would normally create an instance of an 
		 *  object, but because Runnable is an interface, we must give implementation to 
		 *  its abstract method so that its not "too abstract to instantiate"
		 *  
		 */

		Runnable r1 = new Runnable(){

			@Override
			public void run() {
				System.out.println("Running anonymous!");
			}
		};
		//lambda

		/*
		 * Lambda gives implementation to solely abstract methods from functional interfaces
		 * 
		 */

		Runnable r2 = ()-> {
			System.out.println("Running lambda!");
			for(int i = 0; i < 10; i ++){
				System.out.println(i);
			}

		};

		r1.run();
		r2.run();
	}

}
