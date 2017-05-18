package threadsPractice;

public class MyThread extends Thread
{
	StringBuilder testBuilder = new StringBuilder("thread"); 
	StringBuffer testBuffer = new StringBuffer("thread");
	
	public void run()
	{
		for(int i = 0; i < 10; i++)
			System.out.println(testBuilder.append(i));
	}
}
