package com.rev.nested;

public class LocalInner {
	private int data = 50;
	
	void display(){
		class Local{
			void message(){
				System.out.println("In inner class method. data is " + 50);
			}
		}
		
		// inside outer class method display
		Local l = new Local();
		l.message();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalInner outer = new LocalInner();
		outer.display();

	}

}
