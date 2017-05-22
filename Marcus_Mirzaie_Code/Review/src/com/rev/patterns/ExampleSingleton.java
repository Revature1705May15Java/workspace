package com.rev.patterns;

public class ExampleSingleton {

	// private static and final instance of self
	static private final ExampleSingleton INSTANCE = new ExampleSingleton();
	
	// getInstance
	public static ExampleSingleton getInstance(){
		return INSTANCE;
	}
	
	// private constructor
	private ExampleSingleton(){
		
	}
	
	// ACTION
	public void test(){
		System.out.println("This is a test!");
	}
	
	// Truth
	public void theTruthIs(){
		System.out.println("This is useless.");
	}
	
	public static void main(String[] args) {
		ExampleSingleton example = ExampleSingleton.getInstance();
		
		example.test();
		example.theTruthIs();
	}
	
	
}
