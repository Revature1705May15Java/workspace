package com.rev.nested;

abstract class Person {
	abstract void eat();
}

class Animal {
	void eat() {
		System.out.println("animal eating");
	}
}

public class AnonInner {
	
	public static void main(String[] args) {
		Person p = new Person() {
			void eat() { System.out.println("eating"); };
		};
		
		p.eat();
		
		Animal a = new Animal() {
			void eat() { super.eat() ;System.out.println("animals DONT eat!"); }
		};
		a.eat();
		
		Animal b = new Animal();
		b.eat();
	}
}
