package com.rev.nested;

abstract class whiner{
	void whine(){
		System.out.println("WAAA!");
	}
}

public class AllFour {
	int data = 50;
	
	public static void main(String[] args) {
		
		// Anonymous Inner
		whiner w = new whiner(){
			void whine(){
				super.whine();
				System.out.println("BOOHOO!");
			}
		};
		w.whine();
		
		// Member Inner
		AllFour a = new AllFour();
		mediator m = a.new mediator();
		m.mediate();
		
		// Static Inner
		instigator i = new instigator();
		i.instigate();
		
		// Local Inner
		a.complain();
		
	}
	
	private class mediator{
		void mediate(){
			System.out.println("Can't we all just get along?");
		}
	}
	
	static class instigator{
		void instigate(){
			System.out.println("It's all your fault!");
		}
	}
	
	void complain(){
		class complainer{
			void bark(){
				System.out.println("Why am I on the outside?");
			}
		}
		complainer c = new complainer();
		c.bark();
	}
	
}
