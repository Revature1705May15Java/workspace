package com.ex.dao;


import java.util.List;

import com.ex.pojos.Person;

public interface DAO {
	
	void createPerson(Person p);
	Person getPersonById(int id);
	List <Person> getAll();
	public void deleteById(int id);
	public void update(Person p);
	Person getPersonByIdC(int id);
	
}