package com.ex.test;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Person;

public class Tester {

	public static void main(String[] args) {
		
		DaoImpl dao = new DaoImpl();
		Person p = new Person();
		p.setBio("I'm amazing");
		p.setFn("Genesis");
		p.setLn("Bonds");
		dao.addPerson(p);
	}

}