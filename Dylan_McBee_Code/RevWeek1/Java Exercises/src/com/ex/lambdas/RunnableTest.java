package com.ex.lambdas;

public class RunnableTest {

	public static void main(String[] args) {

		
		Runnable r1 = new Runnable(){
			
			@Override
			public void run(){
				System.out.println("Running anonymous!");
			}
		};
		//lambda
		Runnable r2 = ()-> System.out.println("Running lambda!");
		for(int i = 0; i < 10; i++) System.out.println(i);
		r1.run();
		r2.run();
	}

}
