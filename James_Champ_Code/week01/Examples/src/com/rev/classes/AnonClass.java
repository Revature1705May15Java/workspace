package com.rev.classes;

abstract class Person {
	abstract void eat();
}

public class AnonClass {
	
	public static void main(String[] args) {
		doSomething(new Person() {
			void eat() {
				System.out.println("Eating now...");
			}
		});
	}
	
	private static void doSomething(Person p) {
		System.out.println("Doing something...");
		p.eat();
	}
}
