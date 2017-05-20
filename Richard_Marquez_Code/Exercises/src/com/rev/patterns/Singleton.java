package com.rev.patterns;

public class Singleton {
	private static Singleton INSTANCE = new Singleton();
	private String msg;
	
	public static Singleton getInstance() {
		return INSTANCE;
	}
	
	private Singleton() {
		msg = "singleton messaging...";
	}
	
	public String getMsg() {
		return msg;
	}
}
