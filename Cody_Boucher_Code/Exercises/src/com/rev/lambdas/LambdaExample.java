package com.rev.lambdas;

public class LambdaExample {

	public static void main(String[] args) {
		
		String name = "Boucher";
		stringInfo nameInfo = (String str) -> str.length();
		int getLength = nameInfo.stringLength(name);
		System.out.println("String Length of Boucher is: " + getLength);
		
		int num = 5;
		numberTest numInfo = (int i) -> i % 2 == 0;
		boolean getNum = numInfo.isEven(num);
		System.out.println("Is The Number " + num + " Even: " + getNum);

	}
	
}

interface stringInfo {
	int stringLength(String str);
}

interface numberTest {
	boolean isEven(int i);
}
