package com.ex.main;

import com.ex.dao.Dao;
import com.ex.pojos.Person;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Person p = new Person("Geni", "Bonds");
		Dao dao = new Dao();
		
		dao.createPerson(p);

	}

}
