package com.rev.strings;

public class StringSBCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		StringBuilder sbuild = new StringBuilder(str);
		StringBuffer sbuff = new StringBuffer(str);
		
		str.concat(" world");
		sbuild.append(" world");
		sbuff.append(" world");
		
		System.out.println(str);
		System.out.println(sbuild);
		System.out.println(sbuff);
		
		
		System.out.println(str.subSequence(0, 4));//4 letters
		
	}

}
