package com.rev.operators;

import java.util.ArrayList;

public class Operators {
	
	public static String pal(String s){
		String check = s;
		String temp="";
		
		for(int i=s.length()-1;i >=0;i--){
			
			temp+=s.charAt(i);
			
			
		}
		//System.out.println(s);
		//System.out.println(temp);
		if(temp.equals(s)){
			return temp;
		}else
		return "";
	}
	
	public static boolean isPrime(int i){
		if (i < 2) return false;
        if (i == 2) return true;
        if (i % 2 == 0) return false;
        for (int x = 3; x * x <= i; x += 2)
            if (i % x == 0) return false;
        return true;
	}
	
	public boolean isPal(String s){
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <String> aList = new ArrayList();
		ArrayList <String> bList = new ArrayList();
		
		//karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
		
		aList.add("madam");
		aList.add("karan");
		aList.add("tom");
		aList.add("civic");
		aList.add("radar");
		aList.add("sexes");
		aList.add("jimmy");
		aList.add("kayak");
		aList.add("john");
		aList.add("refer");
		aList.add("billy");
		aList.add("did");
		
		for(int i =0;i<aList.size();i++){
			String t = pal(aList.get(i));
			if(t.equals(aList.get(i)));
				bList.add(t);
		}
	
		System.out.println(aList);
		System.out.println(bList);
		
		ArrayList <Integer> cList = new ArrayList();
		for(int i =0;i<101;i++){
			cList.add(i);
		}
		
		for(int i=0;i<cList.size();i++){
			boolean b = isPrime(cList.get(i));
			if(b){
				System.out.print(cList.get(i)+",");
			}
				
		}
		 

	}

}
