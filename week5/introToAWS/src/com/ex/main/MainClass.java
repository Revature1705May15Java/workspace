package com.ex.main;

import java.util.List;

import com.ex.dao.Impldao;
import com.ex.pojos.Person;

public class MainClass {
	public static void main(String[] args) {
		Person p = new Person("ARandom", "Raion");
		Impldao dao = new Impldao();
		
		dao.createPerson(p);
		
		p = dao.getPersonById(200);
		
		List<Person> people = dao.getAllPeople();
		for(int i = 0; i < people.size(); i++) System.out.println("CRITERIA MET - Person[" + i + "]: " + people.get(i).toString());
		
		//dao.deleteInHQL(p);
		//dao.deletePerson(people.get(0));
		//dao.deletePersonById(200);
		
		//p.setLn("TehRaion");
		
		//dao.updatePerson(p);

		
	}
}
