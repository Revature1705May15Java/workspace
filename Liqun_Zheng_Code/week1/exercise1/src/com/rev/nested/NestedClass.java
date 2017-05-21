package com.rev.nested;
//Anonmous
class lion{
	void printout() {
		System.out.println("Anonmous lion ");
	}
}

abstract class pig{
	abstract void printout();
}

public class NestedClass {
	//static inner class
	
	static int data = 30;
	int x = 35;
	
	
	
	static class Dog{
		void printout(){
			System.out.println("static inner Dog data "+ data);
		}
	}
	
	class Cat{
		void printout(){
			System.out.println("non static inner Cat data: " + data+ " x: " + x);
		}
	}
	
	void printout(){
		class tiger{
			void printout(){
				System.out.println("Locall Inner tiger data: "+ data + " x: " + x);
			}
		}
		tiger t = new tiger();
		t.printout();
		
	}
	
	public static void main(String[] args) {
		//static inner class
		NestedClass.Dog anStatic = new NestedClass.Dog();
		anStatic.printout();
		//non static inner class
		NestedClass i = new NestedClass();
		Cat c = i.new Cat();
		c.printout();
		//Locall Inner 
		NestedClass n = new NestedClass();
		n.printout();
		//Anonymous
		lion l = new lion();
		l.printout();
		
		pig p = new pig(){
			@Override
			void printout(){
				System.out.println("Anonmous pig "+ data);
			}
		};
		p.printout();
		
	}
	
	
}
