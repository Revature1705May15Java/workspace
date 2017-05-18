package threadsPractice;

public class MyRunnable implements Runnable
{
	StringBuffer testBuffer = new StringBuffer("runnable"); 
	StringBuilder testBuilder = new StringBuilder("runnable"); 
	@Override
	public void run() 
	{
		for(int i = 0; i < 10; i++)
			System.out.println(testBuffer.append(i));
	}

}
