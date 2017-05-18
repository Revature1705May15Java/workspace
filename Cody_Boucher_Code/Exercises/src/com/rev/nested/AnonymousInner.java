package com.rev.nested;

abstract class Person {
	abstract void eat();
}

public class AnonymousInner {
	

	public static void main(String[] args) {
		
		Person p = new Person() {

			@Override
			void eat() {
				System.out.println("yum");
			}
			
		};
		
		p.eat();
	}

}
