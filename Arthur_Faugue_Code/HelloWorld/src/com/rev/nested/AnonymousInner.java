package com.rev.nested;
/*
 *  a class that has no name is known as an anonymous class
 *  it should be used if you have to override the method
 *  of a class or an interface
 */

abstract class Person{
	abstract void eat();
		
}

class Animal{
	void eat(){
		System.out.println("animal eats bad food");
	}
}

public class AnonymousInner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person(){

			@Override
			void eat() {
				System.out.println("yum");
				
			}
			
		}; // needs a semicolon because Person p = new Person() is a function also
		
		p.eat();
		
		Animal a = new Animal();
		a.eat();
		
		Animal b = new Animal(){
			void eat(){
				System.out.println("animal eat great food");
			}
		};
		b.eat();
	}

}
