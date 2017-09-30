package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Person;

public interface dao {
	void createPerson(Person p);
	void deletePerson(Person p);
	void updatePerson(Person p);
	Person getPersonById(int id);
	List<Person> getAllPeople();
}
