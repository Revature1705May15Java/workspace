package com.ex.main;

import java.util.List;

import com.ex.dao.BearDAO;
import com.ex.dao.DaoImpl;
import com.ex.pojos.Person;

public class run {

	public static void main(String[] args) {
		List<Person> l;
		
		// TODO Auto-generated method stub
		//Person p= new Person("Bobby","Bushae");
		
		DaoImpl dao = new DaoImpl();
		//dao.createPerson(p);
		//dao.createPerson(p);
		int id = 50;
		//p = dao.getPersonById(id);
		//l = dao.getAll();
		//System.out.println("Is this your guy? "+p);
		//System.out.println(l);
		//dao.getPersonByName("Mary");
		dao.getPersonByIdC(id);
		BearDAO bd = new BearDAO();
		
		
		
	}

}