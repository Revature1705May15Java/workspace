package com.ex.dao;

import java.util.List;

import com.ex.pojos.Person;

public interface DAO {
	void createPerson(Person p);
	Person getPersonById(int id);
	List<Person> getAllPersons();
	void update(Person p);
	void deleteById(int id);
	void specialSelect();
}
