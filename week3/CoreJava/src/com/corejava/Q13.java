package com.corejava;

public class Q13 {
/*
Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1

 */
	public static void Q13m(){
		int num=1;
		for(int i=1;i<5;i++){
			String str= new String();
			for(int j=0;j<i;j++){
				if(num==1){
					num=0;
				}else{
					num=1;
				}
				str=str+num+" ";
			}
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		Q13m();
	}
}

