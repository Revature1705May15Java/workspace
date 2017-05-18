package com.ex.nested;
/*
 * A class that has no name is an anonymous class.
 * It should be use if you have to override the method
 * of a class or an interface.
 */

abstract class Person{
	abstract void eat();
}

class Animal{
	void eat(){
		System.out.println("rawr");
	};
}

public class Anonymous {
	
	int data = 12;
	
	public static void main(String[] args) {
		
		Person p = new Person(){ // anonymous class

			@Override
			void eat() {
				System.out.println("yum");
			}
			
		};
		
		p.eat();
		
		Animal a = new Animal();
		a.eat();
		
		Animal b = new Animal(){ //anonymous class
			void eat(){
				super.eat(); // calling the class method now instead of the overridden method.
				System.out.println("roar!");
			}
		};
		
		b.eat();
		
		
	}
}
