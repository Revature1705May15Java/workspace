package com.ex.beans;

public class SpringBeans 
{
	private String message; 
	
	public void setMessage(String message)
	{
		this.message = message; 
	}
	
	public void getMessage()
	{
		System.out.println("The message is " + message); 
	}
}
