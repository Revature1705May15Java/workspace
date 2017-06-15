package dao;

import pojos.Person;

public interface Dao 
{
	void createPerson(Person p); 
	Person getPersonById(int id); 
	
}
