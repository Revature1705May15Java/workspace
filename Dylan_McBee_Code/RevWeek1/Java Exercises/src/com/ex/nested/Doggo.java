package com.ex.nested;


abstract class Borko{
	abstract void eat();
}

class OmniBorko{
	void eat(){
		System.out.println("OmniBorko eats existence");
	}
}



public class Doggo {

	private int shadyDoggos = 2;
	static int doggos= 1;
	static int manyDoggos = 10;
	
	void display(){
		System.out.println("in display");
		class Local{
			void message(){
				System.out.println("in inner class method. Shady doggos have appeared. Count is " + shadyDoggos);
			}
		}
		Local l = new Local();
		l.message();
	}
	class Inner{
		int moreDoggos = 3; // shadowing
		void message(){
			System.out.println("in inner method. New count of Doggos is " + moreDoggos);
			System.out.println("Many more doggos! New count is " + manyDoggos);;
		}
	}
	
	static class DoggoCount{
		void message(){
			System.out.println("In my inner class! Doggos present " + doggos);
			System.out.println(this.getClass());
		}
	}
	public static void main(String[] args) {
		Doggo.DoggoCount objectOfDc = new Doggo.DoggoCount();
		DoggoCount objDc = new DoggoCount();
		
		objDc.message();
		
		objectOfDc.message();
		
		Doggo d = new Doggo();
		Doggo.Inner i = d.new Inner(); // what is this .new method/keyword process called
		i.message();
		
		Doggo meme = new Doggo();
		meme.display();
		
		Borko borko = new Borko(){

			@Override
			void eat() {
				System.out.println("Borko is please with meal");
			}
			
		};
		borko.eat();
		
		OmniBorko ob = new OmniBorko();
		ob.eat();
		OmniBorko bo = new OmniBorko(){
			void eat(){
				System.out.println("OmniBorko feast");
			}
		};
		bo.eat();
	}
	
}