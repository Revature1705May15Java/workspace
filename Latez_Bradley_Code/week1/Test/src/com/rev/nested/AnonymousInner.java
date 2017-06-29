package com.rev.nested;
/*
 * a class that has no name is known as an anonymous class
 * it should be used if you have to override the method 
 * of a class or an interface
 * 
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
		
		Person p = new Person(){

			@Override
			void eat() {
				System.out.println("yum");
			}
			
			void drink(){
				
			}
			
		};
		
		
	
		
		
		p.eat();
		
		
		Animal a = new Animal();
		a.eat();
		
		Animal b = new Animal(){
			void eat(){
				a.eat();
				super.eat();
				System.out.println("animals eat great food");
			}
			
		};
		b.eat();
		
		
		
		

	}

}
