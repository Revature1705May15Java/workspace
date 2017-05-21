package com.rev.singleton;

import java.util.HashSet;
import java.util.Set;

public class Singleton {
	private static final Singleton INSTANCE = new Singleton();
	private Set<Integer> studentID;
	
	public static Singleton getInstance(){
		return INSTANCE;
	}
	
	private Singleton(){
		
		studentID = new HashSet<Integer>();
		studentID.add(5468);
		studentID.add(5545);
		studentID.add(5535);
		studentID.add(5445);
	}
	public boolean remove(Integer id){
		return studentID.remove(id);
	}
	public static void main(String[] args){
		removeStudent(5468);
		
	}
	private static void removeStudent(Integer id){
		Singleton show = Singleton.getInstance();
		System.out.println(show.remove(id));
	}
}
