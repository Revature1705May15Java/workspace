package abstractInherit;

//Write a program having a concrete subclass that inherits three abstract methods from a superclass.
//Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: 

public class abstractinherit extends abstractClass{

	public static void main(String[] args) {
		
	}
	
	public void printWelcome() {
		System.out.println("Welcome!");
	}

	public boolean getTruth() {
		double random = Math.random();
		if(random > 0.5) return true;
		return false;
	}

	public int divide(int x, int y) {
		return x/y;
	}
	
}
