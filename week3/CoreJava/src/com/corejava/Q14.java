package com.corejava;

import java.time.LocalDate;
import java.util.Date;

public class Q14 {
/*
. Write a program that demonstrates the switch case. 
Implement the following functionalities in the cases:
Case 1: Find the square root of a number 
  using the Math class method. 
Case 2: Display today�s date.
Case 3: Split the following string and store it in a 
 sting array. �I am learning Core Java�

 */
	public static String[] Q13m(int switcher,int numtoroot){
		switch(switcher){
		case(1):
			System.out.println(Math.sqrt(numtoroot));
			return null;
		case(2):
			LocalDate localdate = LocalDate.now();
			System.out.println(localdate);
			return null;
		case(3):
			String cjava="I am learning Core Java";
			String[] cjarray=new String[cjava.length()];
			for(int i=0;i<cjava.length();i++){
				cjarray[i]=""+cjava.charAt(i);
			}
			return cjarray;
		default:
			return null;
		}
	}
	public static void main(String[] args) {
		Q13m(1,4);
		Q13m(2,0);
		String[] array=Q13m(3,0);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}