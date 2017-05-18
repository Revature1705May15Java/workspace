package com.ex.nested;

public class LocalInner {
	
	private int data = 7;
	
	void display(){
		class Local{
			void message(){
				System.out.println("In inner class method. data is " + data);
			}
		}
		
		Local l = new Local();
		l.message();
	}
	
	
	public static void main(String[] args) {
		LocalInner outer = new LocalInner();
		outer.display();
		
		
	}
	
}
