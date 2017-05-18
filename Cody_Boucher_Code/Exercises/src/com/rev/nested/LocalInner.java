package com.rev.nested;

public class LocalInner {
	private int data = 50;
	void display() {
		class Local {
			void message() {
				System.out.println("in inner class method data is " + data);
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
