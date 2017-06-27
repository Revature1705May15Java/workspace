package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Person;

public interface DAO {
	
	void createPerson(Person p);
	Person getPersonById(int id);
	ArrayList<Person> getAllPeople();
	boolean updatePerson(Person p);
	boolean deletePerson(int id);
}
