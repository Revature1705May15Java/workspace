package com.ex.main;

import java.util.List;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Person;

public class MainClass {
	
	public static void main(String[] args) {
//		DaoImpl dao = new DaoImpl();
//		List<Person> people=dao.getAllPersons();
//		for(Person p:people){
//			System.out.println(p);
//		}
//		
		DaoImpl dao = new DaoImpl();
		Person p = new Person();
		p.setFirstname("wowzer");
		p.setLastname("guy");
		dao.createPerson(p);
//		dao.deleteById(50);
//		dao.specialSelect();
		
	}
}