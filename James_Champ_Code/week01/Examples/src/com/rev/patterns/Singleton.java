package com.rev.patterns;

import java.util.LinkedList;

public class Singleton {
	public static final Singleton SINGLETON = new Singleton();
	private LinkedList<Integer> list;
	
	private Singleton() {
		super();
		list = new LinkedList<Integer>();
	}
	
	public static Singleton getInstance() {
		return SINGLETON;
	}
	
	public void storeInt(int i) {
		list.add(i);
	}
	
	public int getInt(int index) {
		return list.get(index);
	}
}
