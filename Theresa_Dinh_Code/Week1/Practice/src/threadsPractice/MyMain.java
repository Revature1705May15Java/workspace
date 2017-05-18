package threadsPractice;

public class MyMain 
{
	public static void main(String[] args)
	{
		Runnable r = new MyRunnable(); 
		Thread t = new Thread(r); 
		
		Thread t2 = new MyThread(); 
		
		
		t.start(); 
		t2.start();
	}
}
