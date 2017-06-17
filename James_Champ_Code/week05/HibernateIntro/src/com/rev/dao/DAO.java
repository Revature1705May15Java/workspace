package com.rev.dao;

import java.util.List;

import com.rev.pojos.Person;

public interface DAO {
	void createPerson(Person p);
	Person getPersonById(int id);
	List<Person> getAllPersons();
	void update(Person p);
	void removePerson(Person p);
}
