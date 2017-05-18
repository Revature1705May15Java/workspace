package com.rev.nested;

abstract class Sea{
	abstract void swim();
}
public class NestedAll {
	
	static class walk{ // static local inner class
		void walked(){
			System.out.println("Stati Inner Class");
		}
	}
	
	class fly{ // local inner class
		void message(){
			System.out.println("Inner Class");
		}
	}
	
	void check(){ // nested inner class
		class drive{
			void messageA(){
				System.out.println("Local Inner Class");
			}
		}
		drive t = new drive();
		t.messageA();
	}
	public static void main(String[] args) {
		
		Sea n = new Sea(){//Abstract inner class

			@Override
			void swim() {
				System.out.println("Anonymous Inner Class");
				
			}
			
		};
		// call abstract
		n.swim();
		
		//call static inner class
		NestedAll.walk w = new NestedAll.walk();
		w.walked();
		
		//call inner non static class
		NestedAll n1 = new NestedAll();
		fly f = n1.new fly();
		f.message();
		
		//call local inner class
		NestedAll n2 = new NestedAll();
		n2.check();
	}
	
	
}
