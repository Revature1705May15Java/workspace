package com.rev.p20;

public class MoviePerson 
{
	String name;
	String state;
	int age;
	
	public MoviePerson ()
	{
		
	}
	
	public MoviePerson(String n, String s, int a) 
	{
		name = n;
		state = s;
		age = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() 
	{
		String s = "Name: " + name +
				"\nAge: " + age +
				"\nState: " + state;
		
		return s;
	}
	
	
	
	
}
