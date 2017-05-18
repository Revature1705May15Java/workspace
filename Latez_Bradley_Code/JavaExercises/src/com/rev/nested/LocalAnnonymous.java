package com.rev.nested;
/**A class that has no name is known as
 * an anonymous class
 * It should be used if you have to override the method
 * of a class or an interface
 * 
 * @author Tez
 *
 */

abstract class Person{
	abstract void eat();
}

class Animal{
	void eat(){
		System.out.println("*animal noises*");
	}
}

public class LocalAnnonymous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person(){

			@Override
			void eat() {
				System.out.println("yum");
				
			}
			
		};//Because person is abstract
		//Annon classes are used in conjuction with abstract classes and interfaces
		p.eat();
		
		Animal a = new Animal();
		a.eat();
		
		Animal b = new Animal(){
			void eat(){
				System.out.println("animals eat great food");
			}
		};
		
		b.eat();
	}

}
