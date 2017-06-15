package com.ex.main;

import java.util.List;

import com.ex.dao.BearDao;
import com.ex.dao.Impldao;
import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.HoneyPot;
import com.ex.pojos.Person;

public class MainClass {
	public static void main(String[] args) {
		Person p = new Person("Max", "Minimum");
		Impldao dao = new Impldao();
		
		//dao.createPerson(p);
		
		//p = dao.getPersonById(150);
		System.out.println(p.toString());
		List<Person> people = dao.getAllPeople();
		//dao.deleteInHQL(p);
		//dao.deletePerson(people.get(0));
		//dao.deletePersonById(100);
		for(int i = 0; i < people.size(); i++) System.out.println("CRITERIA MET - Person[" + i + "]: " + people.get(i).toString());
		//p.setLn("TehRaion");
		
		//dao.updatePerson(p);
		
		BearDao bearWithMe = new BearDao();
		Bear b = new Bear();
		HoneyPot hp = new HoneyPot();
		Cave c = new Cave();
		
		
	}
}