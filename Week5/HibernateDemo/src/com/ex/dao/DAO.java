package com.ex.dao;

import com.ex.pojos.Person;

public interface DAO {
	
	void createPerson(Person p);
	Person getPersonById(int id);

}
