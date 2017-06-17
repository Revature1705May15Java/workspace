package com.rev.main;

import com.rev.dao.DAOImpl;
import com.rev.pojos.Person;

public class Main {
	public static void main(String[] args) {
		
		DAOImpl dao = new DAOImpl();
		Person person = dao.getPersonById(50);
		person.setBio("This is some new biographical information...");
		dao.update(person);
		person = dao.getPersonById(100);
		dao.remove(person);
	}
}
