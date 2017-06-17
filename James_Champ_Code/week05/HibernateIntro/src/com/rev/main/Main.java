package com.rev.main;

import java.util.ArrayList;

import com.rev.dao.DAOImpl;
import com.rev.pojos.Person;

public class Main {
	
	public static void main(String[] args) {
//		Person p;
//		DaoImpl dao = new DaoImpl();
//		
//		//dao.createPerson(p);
//		
//		//p = dao.getPersonById(1);
//		//System.out.println("hello " + p);
//		
//		
//
//		dao.deleteById(50);
////		p = dao.getPersonById(50);
////		p.setFirstname("Genesis");
////		dao.update(p);
////		
////		List<Person> people = dao.getAllPeople();
////		
////		for(Person x:people){
////			System.out.println(x);
////		}
		
//		
//		
//		BearDAO bearDao = new BearDAO();
//	
//		bearDao.createBearsDemo();
		Person p1 = new Person();
		p1.setFirstName("Jaja");
		p1.setLastName("Lalo");
		
		Person p2 = new Person();
		p2.setFirstName("HiyaJaja");
		p2.setLastName("Lalol");
		
		Person p3 = new Person();
		p3.setFirstName("Mark");
		p3.setLastName("Lalo");
		
		Person p4 = new Person();
		p4.setFirstName("Roz");
		p4.setLastName("Lalo");
		
		DAOImpl dao = new DAOImpl();
//		dao.createPerson(p1);
//		dao.createPerson(p2);
//		dao.createPerson(p3);
//		dao.createPerson(p4);
		
		ArrayList<Person> people = dao.getPeopleLike("*Jaja");
		
		for(Person p : people) {
			System.out.println(p.getFirstName());
		}
	}

}
