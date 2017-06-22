package com.ex.test;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Person;

public class Tester 
{

	public static void main(String[] args) 
	{
		
		DaoImpl dao = new DaoImpl();
		Person p = new Person();
		p.setBio("I'm awesome");
		p.setFn("Chantel");
		p.setLn("Boor");
		dao.addPerson(p);
	}

}