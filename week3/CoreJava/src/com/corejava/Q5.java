package com.corejava;

public class Q5 {
/*
 * Q5. Write a substring method that accepts a string str and an integer 
 * idx and returns the substring contained between 0 and idx-1 inclusive. 
 *Do NOT use any of the existing substring methods in the String, StringBuilder, 
 *or StringBuffer APIs.
 */
	public String Q5m(String str, int idx) {
		String temp=new String();
		for(int i=0;i<idx;i++){
			temp=temp+str.charAt(i);
		}
		return temp;
	}
}
