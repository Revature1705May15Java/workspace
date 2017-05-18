package com.randomexercises.nested.fourexamples;

class Outer{
	
}

class Animal{
	class Dog{//inner class
		void message(){
			System.out.println("bark");
		}
	}
}



abstract class Person{
	void speak(){
		System.out.println("I'm just a guy with ordinary methods, nothing to see here");
	}
	
}
class ordinaryPerson extends Person{}



public class FourInnerClassTypes {
	
	static class StaticInner{//static nested class 
		void Talk(){
			System.out.println("It's not that hard to access me compared to nonstatic inner class, but I can keep static methods and access static variables.");
		}
	}
	class Inner{//nonstatic inner class
		void Talk(){
			System.out.println("You can use my methods from an object belonging to the outer class, but only from an object set to my class,created by an object of the outer class type.");
		}
	}
	class LocalInner{
		void Talk(){
			System.out.println("Local Inner objects have instantiation through their method calls!");
		}
		LocalInner li=new LocalInner();
	}

	public static void main(String[] args) {
		
		FourInnerClassTypes oi=new FourInnerClassTypes();
		Inner i= oi.new Inner();
		i.Talk();
		StaticInner si = new StaticInner();
		si.Talk();
		
		
		Person j = new Person(){
			@Override
			void speak(){
				System.out.println("I'm j, taking over the methods, but only within FourInnerClassTypes(I use anonymous inner classes)");
			}
		};
		Person guy= new ordinaryPerson();
		guy.speak();
		j.speak();
		
		

	}

}
