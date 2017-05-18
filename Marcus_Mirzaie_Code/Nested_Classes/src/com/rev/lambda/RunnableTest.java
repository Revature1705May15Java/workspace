package com.rev.lambda;

public class RunnableTest {

	public static void main(String[] args) {
		
		// Anonymous class runnable
		Runnable r1 = new Runnable(){
			
			@Override
			public void run(){
				System.out.println("Running annonymous");
			}
		};
		//lambda
		Runnable r2 = ()-> {System.out.println("Running lambda!");
			for(int i=0;1<10;i++){
				System.out.println(i);
			}
		};
	}
}
