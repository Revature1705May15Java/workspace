package com.randomexercises.nested;
/*
 * a class that has no name is known as an anonymous class
 * it should be used if you have to override the method
 * of a class or interface
 */


abstract class Person{
	abstract void eat();
}

class Animal{
	void eat(){
		System.out.println("animals eat bad food");
	}
}

public class AnonymousInner {

	public static void main(String[] args) {
			int x=2;
		Person p = new Person(){

				@Override
				void eat() {
					System.out.println("yum");					
				}
				
			};
			p.eat();
			
		Person j = new Person(){

			@Override
			void eat() {
				System.out.println("hi");
			};
			
			
			
			
		};
	}

}

