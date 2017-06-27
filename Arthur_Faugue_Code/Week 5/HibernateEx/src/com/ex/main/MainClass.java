package com.ex.main;

import com.ex.dao.BearDAO;
import com.ex.dao.DaoImpl;
import com.ex.pojos.Bear;
import com.ex.pojos.HoneyPot;
import com.ex.pojos.Person;

public class MainClass {
	public static void main(String[] args) {
		Person p;
		DaoImpl dao = new DaoImpl();
		
//		dao.createPerson(p);
		p = dao.getPersonById(1);
		System.out.println("hello " + p);
//		dao.deletePerson(50);
//		dao.getAllPeople();
		
//		BearDAO bearDao = new BearDAO();
//		Bear b = new Bear();
//		HoneyPot hp = new HoneyPot();
	}
}
