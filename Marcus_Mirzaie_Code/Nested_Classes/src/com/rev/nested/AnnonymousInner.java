package com.rev.nested;

abstract class Person{
	abstract void eat();
}

class Animal{
	void eat(){
		System.out.println("CHOMP!");
	}
}

public class AnnonymousInner {

	public static void main(String[] args) {
		Person p = new Person(){
			void eat(){
				
			}
		};
		p.eat();
		
		Animal a = new Animal();
		a.eat();
		
		Animal b = new Animal(){
			void eat(){
				super.eat();
				System.out.println("SMACK!");
			}
		};
		b.eat();	
	}

}
