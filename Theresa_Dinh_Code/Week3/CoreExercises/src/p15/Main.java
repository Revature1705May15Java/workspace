package p15;

public class Main 
{

	public static void main(String[] args) 
	{
		Math m = new Math(); 
		
		int num = m.add(333, 333); 
		int num2 = m.multiply(333, 2); 
		
		System.out.println(num + " " + num2);
	}

}
